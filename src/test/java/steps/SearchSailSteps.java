package steps;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import pageobjects.ResultFilters;
import pageobjects.SailDetails;
import pageobjects.SearchCruices;

import java.net.MalformedURLException;
import java.net.URL;

public class SearchSailSteps {

    private WebDriver driver;
    ResultFilters resultFilters;
    SailDetails sailDetails;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }

    @Given("^The User is on the home page$")
    public void theUserIsOnTheHomePage() {
        driver.get("https://www.carnival.com/");
        driver.navigate().refresh();
    }

    @When("^the user defines the parameters to search for sails$")
    public void theUserDefinesTheParametersToSearchForSails() {
        SearchCruices searchCruice = new SearchCruices(driver);
        searchCruice.closeCookiePolicy();
        searchCruice.clickSailTo();
        searchCruice.clickToBahamas();
        searchCruice.clickDuration();
        searchCruice.clickSixToNiceDays();
    }

    @And("^the user confirms the searching to get results$")
    public void theUserConfirmsTheSearchingToGetResults() {
        SearchCruices searchCruice = new SearchCruices(driver);
        searchCruice.clickSearchButton();
    }


    @Then("^it shows the sails that meet the searching parameters with \"([^\"]*)\"$")
    public void itShowsTheSailsThatMeetTheSearchingParametersWith(String gridType) throws Throwable {
        resultFilters = new ResultFilters(driver);
        Assert.assertEquals(resultFilters.getGridType(),gridType);
    }

    @Given("^The User has done a searching$")
    public void theUserHasDoneASearching() {
        resultFilters = new ResultFilters(driver);
    }

    @When("^the user wants to filter by price$")
    public void theUserWantsToFilterByPrice() {
        resultFilters = new ResultFilters(driver);
        resultFilters.clickPrincingFilter();
    }

    @When("^the user sets the ranges values$")
    public void theUserSetsTheRangesValues() {
        resultFilters = new ResultFilters(driver);
        resultFilters.clickMinPointer();
    }

    @Then("^the sails results amount are \"([^\"]*)\"$")
    public void theSailsResultsAmountAre(String resultAmount) throws Throwable {
        resultFilters = new ResultFilters(driver);
        resultFilters.getResultAmount();
        Assert.assertEquals(resultFilters.getResultAmount(), resultAmount);
    }

    @When("^the user wants to sort by price$")
    public void theUserWantsToSortByPrice() {
        resultFilters = new ResultFilters(driver);
    }

    @Then("^the results are ordered by \"([^\"]*)\"$")
    public void theResultsAreOrderedBy(String byPrice) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(resultFilters.testSortByPrice(), byPrice);
    }


    @And("^The user selects a sail$")
    public void theUserSelectsASail() {
        resultFilters = new ResultFilters(driver);
        resultFilters.clickSelectSail();
    }

    @Then("^the user sees the itinerary page$")
    public void theUserSeesTheItineraryPage() {
        Assert.assertEquals(driver.getTitle(),"6 Day Bahamas Cruise From Norfolk | Carnival Cruise Line");
        sailDetails.getBookNowButton();
    }

    @And("^The user sees the bookNow button$")
    public void theUserSeesTheBookNowButton() {
        sailDetails = new SailDetails(driver);
        Assert.assertNotNull(sailDetails.getBookNowButton());
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed())
            takeScreenshot(scenario);
        driver.quit();
    }

    private void takeScreenshot(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }
}

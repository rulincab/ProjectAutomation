package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import pageobjects.ResultFilters;
import pageobjects.SearchCruices;

public class SearchSailSteps {

    private WebDriver driver;
    ResultFilters resultFilters;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "D:\\CURSO\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();

        //System.setProperty("webdriver.chrome.driver", "D:\\CURSO\\Drivers\\chromedriver.exe");
        //driver = new ChromeDriver();

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

    @After
    public void tearDown(){
        driver.quit();
    }



}

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjects.ResultFilters;
import pageobjects.SailDetails;
import pageobjects.SearchCruices;

public class Automation {

    private WebDriver driver;
    ResultFilters resultFilters;
    SailDetails sailDetails;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "D:\\CURSO\\Drivers\\geckodriver.exe");
        //System.setProperty("webdriver.chrome.driver", "D:\\CURSO\\Drivers\\chromedriver.exe");

        //driver = new ChromeDriver();
        driver = new FirefoxDriver();

        driver.get("https://www.carnival.com/");
        driver.navigate().refresh();

    }

    @Test
    public void testGridType() {
        SearchCruices searchCruice = new SearchCruices(driver);
        searchCruice.closeCookiePolicy();
        searchCruice.clickSailTo();
        searchCruice.clickToBahamas();
        searchCruice.clickDuration();
        searchCruice.clickSixToNiceDays();
        searchCruice.clickSearchButton();
        resultFilters = new ResultFilters(driver);
        Assert.assertEquals(resultFilters.getGridType(),"Grid view active");

    }

    @Test
    public void testPricingFilter() throws InterruptedException {
        resultFilters = new ResultFilters(driver);
        resultFilters.clickPrincingFilter();
        resultFilters.clickMinPointer();
        Assert.assertEquals(resultFilters.getResultAmount(), "4 Results");
    }


    @Test
    public void testSortFilter(){
        resultFilters = new ResultFilters(driver);
        resultFilters.testSortByPrice();
        Assert.assertEquals(resultFilters.testSortByPrice(), "By price");
    }

    @Test
    public void testShowItinerary(){
        resultFilters = new ResultFilters(driver);
        resultFilters.clickSelectSail();
        Assert.assertEquals(driver.getTitle(),"6 Day Bahamas Cruise From Norfolk | Carnival Cruise Line");
        sailDetails.getBookNowButton();
        Assert.assertNotNull(sailDetails.getBookNowButton());
    }


    @AfterClass
    public void tearDown(){
    }
}

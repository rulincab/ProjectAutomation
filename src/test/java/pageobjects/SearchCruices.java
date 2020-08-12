package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class SearchCruices implements WebDriver {

    private WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public SearchCruices(WebDriver browser) {
        driver = browser;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    //Locator
    @FindBy(id = "cookie-consent-btn")
    private WebElement cookiePolicy;

    @FindBy(css = "li[class='cdc-filters-tab cdc-filters-tab--destinations']")
    private WebElement sailTo;

    @FindBy(css = "button[aria-label='The Bahamas ']")
    private WebElement toBahamas;

    @FindBy(css = "a[class='cdc-filters-tab-link cdc-filters-tab-link--durations']")
    private WebElement duration;

    @FindBy(css = "button[aria-label='6 - 9 Days ']")
    private WebElement sixToNineDays;

    @FindBy(css = "li a[data-tealium='cdc-search-cruises-cta']")
    private WebElement searchButton;

    //Actions
    public void closeCookiePolicy() {
        wait.until(ExpectedConditions.elementToBeClickable(cookiePolicy)).click();
    }

    public void clickSailTo() {
        wait.until(ExpectedConditions.elementToBeClickable(sailTo)).click();

    }

    public void clickToBahamas() {
        wait.until(ExpectedConditions.elementToBeClickable(toBahamas));
        toBahamas.click();
    }

    public void clickDuration() {
        wait.until(ExpectedConditions.elementToBeClickable(duration));
        duration.click();
    }

    public void clickSixToNiceDays() {
        wait.until(ExpectedConditions.elementToBeClickable(sixToNineDays));
        sixToNineDays.click();
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    @Override
    public void get(String url) {

    }

    @Override
    public String getCurrentUrl() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public String getPageSource() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {

    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return null;
    }

    @Override
    public TargetLocator switchTo() {
        return null;
    }

    @Override
    public Navigation navigate() {
        return null;
    }

    @Override
    public Options manage() {
        return null;
    }
}

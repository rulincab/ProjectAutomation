package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ResultFilters {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions move;
    private Action action;

    public ResultFilters(WebDriver browser) {
        driver = browser;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    //Locators
    @FindBy(id = "sfn-nav-pricing")
    private WebElement pricingFilter;

    @FindBy(css = "div[class='sbls-container__layout-switchers'] a:first-child")
    private WebElement gridType;

    @FindBy(css = "span.rz-pointer.rz-pointer-min")
    private WebElement minPointer;

    @FindBy(css = "span.sbsc-container__result-count.ng-binding")
    private WebElement resultAmount;

    @FindBy(css = "i.fa.fa-undo")
    private WebElement resetSearch;

    @FindBy(css = "span.vrgf-price-box__price-value.ng-binding")
    private List<WebElement> orderPrice;

    @FindBy(id = "sortOption not found")
    private WebElement sortByPrice;

    @FindBy(xpath = "//span[text()=' The Bahamas from Norfolk, VA ']")
    private WebElement selectSail;

    //Actions
    public void clickPrincingFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(pricingFilter));
        pricingFilter.click();
    }

    public String getGridType() {

        return wait.until(ExpectedConditions.visibilityOf(gridType)).getText();
    }

    public void clickMinPointer() {
        wait.until(ExpectedConditions.elementToBeClickable(minPointer)).click();
        move = new Actions(driver);
        action = move.dragAndDropBy(minPointer, 530, 0).build();
        action.perform();
    }

    public String getResultAmount() {
        wait.until(ExpectedConditions.visibilityOf(resetSearch));
        return wait.until(ExpectedConditions.visibilityOf(resultAmount)).getText();
    }

    public String testSortByPrice() {
        return wait.until(ExpectedConditions.visibilityOf(sortByPrice)).getText();
    }

    public void clickSelectSail() {
        wait.until(ExpectedConditions.elementToBeClickable(selectSail)).click();
    }
}

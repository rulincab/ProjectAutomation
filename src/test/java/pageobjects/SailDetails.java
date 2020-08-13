package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SailDetails {
    private WebDriver driver;
    private WebDriverWait wait;

    public SailDetails(WebDriver browser) {
        driver = browser;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(id = "sm-booking-btn'")
    private WebElement bookNowButton;

    public String getBookNowButton(){
        return wait.until(ExpectedConditions.visibilityOf(bookNowButton)).getText();
    }


}

package pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {

    @FindBy(id = "user-name")
    @CacheLookup
    WebElement txt_username;

    @FindBy(id = "password")
    WebElement txt_password;

    @FindBy(id = "login-button")
    WebElement btn_login;

    @FindBy(partialLinkText = "raghav")
    List<WebElement> myLinks;

    @FindBy(how = How.ID, using = "name")
    WebElement abc;

    @FindBy(className = "app_logo")
    WebElement txt_logo;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void enterUsername(String username) {
        txt_username.sendKeys(username);
    }

    public void enterPassword(String password) {
        txt_password.sendKeys(password);
    }

    public void clickOnLogin() {
        btn_login.click();
    }

    public void checkLogoIsDisplayed() {
        txt_logo.isDisplayed();
    }
}

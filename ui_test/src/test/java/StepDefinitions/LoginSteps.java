package StepDefinitions;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.junit.Assert;

import io.cucumber.java.en.*;
import pageFactory.HomePage;
import pageFactory.LoginPage;

public class LoginSteps {

	WebDriver driver = null;
	LoginPage login;
	HomePage home;

	@Given("user is on login page")
	public void user_is_on_login_page() {

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : " + projectPath);

		// System.setProperty("webdriver.gecko.driver", projectPath +
		// "/src/test/resources/drivers/geckodriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");
		driver = new ChromeDriver(options);

		driver.navigate().to("https://www.saucedemo.com/");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {

		login = new LoginPage(driver);

		login.enterUsername(username);
		login.enterPassword(password);
		Thread.sleep(2000);
	}

	@When("^user enters (.*) without password")
	public void user_enters_empty_password(String username) throws InterruptedException {
		login = new LoginPage(driver);

		login.enterUsername(username);
		Thread.sleep(2000);
	}

	@And("clicks on login button")
	public void user_clicks_on_login() {
		login.clickOnLogin();

	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		home = new HomePage(driver);
		Thread.sleep(2000);
		home.checkLogoIsDisplayed();

		driver.close();
		driver.quit();
	}

	@Then("^error (.*) appear")
	public void error_appear(String errorType) throws InterruptedException {
		switch (errorType) {
			case "invalid_username/password":
				Assert.assertEquals(login.getErrorMessage(),
						"Epic sadface: Username and password do not match any user in this service");
				System.out.println(login.getErrorMessage());
				break;
			case "username_required":
				login.getErrorMessage();
				Assert.assertEquals(login.getErrorMessage(),
						"Epic sadface: Username is required");
				System.out.println(login.getErrorMessage());
				break;
			case "password_required":
				login.getErrorMessage();
				Assert.assertEquals(login.getErrorMessage(),
						"Epic sadface: Password is required");
				System.out.println(login.getErrorMessage());
				break;
			case "locked_out":
				login.getErrorMessage();
				Assert.assertEquals(login.getErrorMessage(),
						"Epic sadface: Sorry, this user has been locked out.");
				System.out.println(login.getErrorMessage());
				break;
			default:
				throw new NotImplementedException();
			// code block
		}
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
}

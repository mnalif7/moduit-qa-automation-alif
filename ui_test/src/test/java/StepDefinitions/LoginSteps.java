package StepDefinitions;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

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
	}

}

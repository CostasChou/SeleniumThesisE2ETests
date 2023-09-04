package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import webpages.Homepage;
import webpages.LogInWebpage;

public class TC09_HamburgerMenuItemsWhenColapsedOK {
	static WebDriver driver = null;
	static String webpage = "https://sso.ihu.gr/login?service=https%3A%2F%2Funiportal.ihu.gr%2Flogin%2Fcashttps://sso.ihu.gr/login?service=https%3A%2F%2Funiportal.ihu.gr%2Flogin%2Fcas";
	static ExtentReports extent;
	ExtentHtmlReporter htmlReporter;

	//Runs before test. Works as a SetUp for the test to be executed.Prerequisuites of the test could be performed here
	@BeforeTest
	@Parameters({"browser"})
	public void setUpTest(String browser) {
		//Save current user directory to projectPath variable.
		String projectPath = System.getProperty("user.dir");

		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		else if(browser.equalsIgnoreCase("MicrosoftEdge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		// Start reporters.
		htmlReporter = new ExtentHtmlReporter(projectPath + "/TestsReports/TC09_HamburgerMenuItemsWhenColapsedOK.html");
		// Create ExtentReports and attach reporter.
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@Test
	@Parameters({"username", "password"})
	public static void tC09_HamburgerMenuItemsWhenColapsedOK(String username, String password) {
		LogInWebpage logInWebPageObj = new LogInWebpage(driver); 

		// Creates a toggle for the given test, adds all log events under it.    
		ExtentTest test = extent.createTest("TC09: All central menu options are still available when the central menu is collapsed");

		// Steps:
		// Used tests.pass,fail("") commands to log events as info on extent reports for each step.

		logInWebPageObj.visitWebPage(webpage);
		if(driver.getPageSource().contains("Login")) {
			test.pass("Opened web page successfully");
		}
		else {
			test.fail("Web page is not opened successfully");
		}


		logInWebPageObj.setTextInTextFieldUserName(username);
		if(logInWebPageObj.getTextOfTextFieldUserName().equalsIgnoreCase(username)) {
			test.pass("Username " + username + " is successfully entered in username text field.");
		}
		else {
			test.fail("Username " + username + "is not successfully entered in username text field.");
		}

		logInWebPageObj.setTextInTextFieldPassword(password);
		if(logInWebPageObj.getTextOfTextFieldPassword().equalsIgnoreCase(password)) {
			test.pass("Password ******** " + "is successfully entered in password text field.");
		}
		else {
			test.fail("Password ******** " + " is not successfully entered in password text field.");
		}

		if(logInWebPageObj.logInButtonIsDisplayed()) {
			logInWebPageObj.clickLogInButton();
			test.pass("Log in button is clicked");
		}
		else {
			test.fail("Log in button is not clicked");
		}

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		Boolean userIsLoggedIn = logInWebPageObj.userIsLoggedIn();
		if(userIsLoggedIn) {
			// Used tests.pass("") command to log the result of the test as "pass" on extent reports.
			test.pass("User is logged in sucessfully!");
			assert(userIsLoggedIn);
		}
		else {
			// Used tests.fail("") command to log the result of the test as "fail" on extent reports.
			test.fail("User is not logged in.");
			assert(userIsLoggedIn);
		}
		
		Homepage homebageObj = new Homepage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//specify the WebElement till which the page has to be scrolled
		By logOutButton = By.cssSelector("a[data-toggle='tooltip']");
		Boolean logOutButtonIsDisplayedBeforeMenuColapseBoolean = driver.findElement(logOutButton).isDisplayed();
		
		if(logOutButtonIsDisplayedBeforeMenuColapseBoolean) {
			test.pass("Log out button is displayed before the colapse of thecentral menu");
			System.out.println("Log out button is displayed before the colapse of thecentral menu?: " + driver.findElement(logOutButton).isDisplayed());

		}
		else {
			test.fail("Log out button is not displayed before the colapse of thecentral menu");
			System.out.println("Is log out button displayed before the colapse of the central menu?: " + driver.findElement(logOutButton).isDisplayed());

		}
		
		js.executeScript("arguments[0].scrollIntoView();", logOutButton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		homebageObj.clickHamburgerMenuIcon();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//specify the WebElement till which the page has to be scrolled
		WebElement manualGuideButton = driver.findElement(By.linkText("Εγχειρίδιο χρήσης"));
		js.executeScript("arguments[0].scrollIntoView();", manualGuideButton);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Boolean result = driver.findElement(logOutButton).isDisplayed();
		if (result) {
			test.pass("Log out button is displayed after click on collapse menu");
			System.out.println("Log out is displayed");
			assert(result);
		}
		else {
			test.fail("Log out button is not displayed after click on collapse menu");
			System.out.println("Log out is not displayed");
			assert(result);
		}
	}

	//Runs after test. Works as tearDown() function. Repetitive actions that take place after the execution of the steps of the test can be placed here
	@AfterTest
	public void tearDownTest() {
		// Closes  the current window.
		driver.close();
		// Closes all browser windows and ends the WebDriver session.
		driver.quit();
		// Calling flush writes everything to the log file.
		extent.flush();
		System.out.println("Test finalized");
	}
}
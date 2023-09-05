package tests;

import org.openqa.selenium.WebDriver;
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

import webpages.LogInWebpage;

public class TC11_LogInWithoutEnteringPasswordKO {
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
		htmlReporter = new ExtentHtmlReporter(projectPath + "/TestsReports/TC11_LogInWithoutEnteringPasswordKO.html");
		// Create ExtentReports and attach reporter.
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	//Test
	@Test
	@Parameters({"username", "emptyPassword"})
	public static void tC11_LogInWithoutEnteringPasswordKO(String username, String password) throws Exception {
		LogInWebpage logInWebPageObj = new LogInWebpage(driver); 

		// Creates a toggle for the given test, adds all log events under it.    
		ExtentTest test = extent.createTest("TC11: User is not logged in successfully if she/he does not entered a password.");

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
			test.fail("Username " + username + " is  successfully entered in username text field.");
		}
		
		//Wait 2.5 seconds
		Thread.sleep(2500);

		
		logInWebPageObj.setTextInTextFieldPassword(password);
		if(logInWebPageObj.getTextOfTextFieldPassword().equalsIgnoreCase(password)) {
			test.pass("No password is entered in password field");
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

		//Wait 6 seconds
		Thread.sleep(6000);

		Boolean loggedIn = logInWebPageObj.userIsLoggedIn();
		Boolean passwordErrorMessageIsDisplayedBoolean = driver.getPageSource().contains("Password is a required field.");
		if(!loggedIn && passwordErrorMessageIsDisplayedBoolean) {
			// Used tests.pass("") command to log the result of the test as "pass" on extent reports.
			test.pass("User is not logged in successfully and the error message about missing password is displayed");
			assert(true);
		}
		else {
			// Used tests.fail("") command to log the result of the test as "fail" on extent reports.
			test.fail("User is  logged in successfully and the error message about missing password is not displayed");
			assert(false);
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
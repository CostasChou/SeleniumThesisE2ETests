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
import webpages.Homepage;
import webpages.LogInWebpage;

public class TC03_ChangeLanguageOK {
	static WebDriver driver = null;
	static String webpage = "https://sso.ihu.gr/login?service=https%3A%2F%2Funiportal.ihu.gr%2Flogin%2Fcas";
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
		htmlReporter = new ExtentHtmlReporter(projectPath + "/TestsReports/TC03_ChangeLanguageOK.html");
		// Create ExtentReports and attach reporter.
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	//Test
	@Test
	@Parameters({"username", "password"})
	public static void tC03_ChangeLanguageOK(String username, String password) throws Exception {
		LogInWebpage logInWebPageObj = new LogInWebpage(driver); 

		// Creates a toggle for the given test, adds all log events under it.    
		ExtentTest test = extent.createTest("TC03: User changed language successfully");

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

		logInWebPageObj.clickLogInButton();
		
		//Wait 6 seconds
		Thread.sleep(6000);

		if(logInWebPageObj.userIsLoggedIn()) {
			test.pass("User is logged in successfully");
		}
		else {
			test.fail("User is not logged in successfully.");
		}

		Homepage homepageObjHomepage = new Homepage(driver);
		if(homepageObjHomepage.isLanguageDropDownMenuDisplayed()) {
			test.pass("Language drop down menu is displayed");
			homepageObjHomepage.clickLanguageDropDownMenu();
			if(homepageObjHomepage.isGreekChoiceOfDropDownMenuDisplayed() && homepageObjHomepage.isEnglishChoiceOfDropDownMenuDisplayed()) {
				test.pass("Greek and English choices of language drop down menu are displayed");
			}
			else {
				test.fail("Greek and English choices of language drop down menu are not displayed");
			}
		}		
		else {
			test.fail("Language drop down menu is not displayed");
		}

		//Wait 2.5 seconds
		Thread.sleep(2500);
		
		homepageObjHomepage.clickEnglishChoiceOfLanguageDropDownMenu();
			
		//Wait 4 seconds
		Thread.sleep(4000);

		Boolean result = homepageObjHomepage.isLanguageChangedToEnglish();
		if(result) {
			// Used tests.pass("") command to log the result of the test as "pass" on extent reports.
			test.pass("Webpage language is changed to english!");
			assert(result);
		}
		else {
			// Used tests.fail("") command to log the result of the test as "fail" on extent reports.
			test.fail("Webpage language is not changed to english!");
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
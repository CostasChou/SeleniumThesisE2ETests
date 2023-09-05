package tests;

import java.util.Set;

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

public class TC04_ManualGuideOK {
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
		htmlReporter = new ExtentHtmlReporter(projectPath + "/TestsReports/TC04_ManualGuideOK.html");
		// Create ExtentReports and attach reporter.
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	//Test
	@Test
	@Parameters({"username", "password"})
	public static void tC04_ManualGuideOK(String username, String password) throws Exception {
		LogInWebpage logInWebPageObj = new LogInWebpage(driver); 

		// Creates a toggle for the given test, adds all log events under it.    
		ExtentTest test = extent.createTest("TC04: User can open successfully the manual guide.");

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
			test.pass("User is logged in sucessfully!");
		}
		else {
			test.fail("User is not logged in.");
		}

		//Wait 6 seconds
		Thread.sleep(6000);
	

		Homepage homepageObjHomepage = new Homepage(driver);
		// Locate an element (you can use any element on the page)

		//Wait 3 seconds
		Thread.sleep(3000);
		

		JavascriptExecutor js = (JavascriptExecutor) driver;
		//specify the WebElement till which the page has to be scrolled
		WebElement manualGuideButton = driver.findElement(By.linkText("Εγχειρίδιο χρήσης"));
		js.executeScript("arguments[0].scrollIntoView();", manualGuideButton);
		
		//Wait 3 seconds
		Thread.sleep(3000);


		if(homepageObjHomepage.isUserManualButtonDisplayed()) {
			homepageObjHomepage.clickUserManualItemOfCentralMenu();
				
			//Wait 2.5 seconds
			Thread.sleep(2500);

			// Get the handle of the current window
			String currentWindowHandle = driver.getWindowHandle();

			// Get all window handles after the click
			Set<String> windowHandles = driver.getWindowHandles();

			// Iterate through the handles to find the new tab
			for (String windowHandle : windowHandles) {
				if (!windowHandle.equals(currentWindowHandle)) {
					// Switch to the new tab
					driver.switchTo().window(windowHandle);
					//Wait 2 seconds
					Thread.sleep(2000);
					}
				}
			}

			String redirectedLink = driver.getCurrentUrl();
			
			//Wait 1 seconds
			Thread.sleep(1000);

			System.out.println(redirectedLink);
			if(redirectedLink.equalsIgnoreCase("https://uniportal.ihu.gr/feign/student/general/manual?p=A43D7DAF-2AC1-4D15-9560-2AF3BCCB1CF06CE3C38F-D3FD-404E-8333-293309E7D1BE")) {
				// Used tests.pass("") command to log the result of the test as "pass" on extent reports.
				test.pass("Webpage language is changed to english!");
				assert(true);
			}
			else {
				// Used tests.fail("") command to log the result of the test as "fail" on extent reports.
				test.fail("Webpage language is not changed to english!");
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
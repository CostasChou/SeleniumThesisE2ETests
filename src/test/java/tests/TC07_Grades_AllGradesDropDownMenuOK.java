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

public class TC07_Grades_AllGradesDropDownMenuOK {
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
		htmlReporter = new ExtentHtmlReporter(projectPath + "/TestsReports/TC07_Grades_AllGradesDropDownMenuOK.html");
		// Create ExtentReports and attach reporter.
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@Test
	@Parameters({"username", "password"})
	public static void tC01LogInCorrectUsernameCorrectPasswordOK(String username, String password) {
		LogInWebpage logInWebPageObj = new LogInWebpage(driver); 

		// Creates a toggle for the given test, adds all log events under it.    
		ExtentTest test = extent.createTest("TC07: User can successfully see all her/his grades");

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

		Homepage homepageObj = new Homepage(driver);

		if(homepageObj.isGradesOfCentralMenuDisplayed()){
			// Used tests.pass("") command to log the result of the test as "pass" on extent reports.
			test.pass("Grades of central menu is displayed");
		}
		else {
			// Used tests.fail("") command to log the result of the test as "fail" on extent reports.
			test.fail("Grades of central menu is not displayed");
		}

		homepageObj.clickGradesItemOfCentralMenu();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		if(homepageObj.isMyBoardMenuItemOfGradesDisplayed() && homepageObj.isAllGradesMenuItemOfGradesDisplayed() && homepageObj.isByExamPeriodMenuItemOfGradesDisplayed()) {
			test.pass("All menu items of grades central menu item are displayed");
		}
		else {
			test.fail("Not all menu items of grades central menu item are displayed");
		}

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		homepageObj.clickAllGradesMenuItemOfGrades();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		if(homepageObj.isMyBoardMenuItemOfGradesDisplayed() && homepageObj.isAllGradesMenuItemOfGradesDisplayed() && homepageObj.isByExamPeriodMenuItemOfGradesDisplayed()) {
			test.pass("All options of grades menu are displayed");
		}
		else {
			test.fail("Not all options of grades menu are displayed");
		}


		By entriesDropDownMenuOfAllGradesItemOfGrades = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/label[1]/select[1]");
		By fiftyOptionInEntriesDropDownMenuOfAllGradesItemOfGrades = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/label[1]/select[1]/option[1]");
		By oneHundredOptionInEntriesDropDownMenuOfAllGradesItemOfGrades = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/label[1]/select[1]/option[2]");
		By twoHundredOptionInEntriesDropDownMenuOfAllGradesItemOfGrades = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/label[1]/select[1]/option[3]");
		By fiveHundredOptionInEntriesDropDownMenuOfAllGradesItemOfGrades = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/label[1]/select[1]/option[4]");
		By allOptionInEntriesDropDownMenuOfAllGradesItemOfGrades = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[3]/div[3]/div[1]/label[1]/select[1]/option[5]");

		driver.findElement(entriesDropDownMenuOfAllGradesItemOfGrades).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (driver.findElement(fiftyOptionInEntriesDropDownMenuOfAllGradesItemOfGrades).isDisplayed() && driver.findElement(oneHundredOptionInEntriesDropDownMenuOfAllGradesItemOfGrades).isDisplayed()
				&& driver.findElement(twoHundredOptionInEntriesDropDownMenuOfAllGradesItemOfGrades).isDisplayed() && driver.findElement(fiveHundredOptionInEntriesDropDownMenuOfAllGradesItemOfGrades).isDisplayed()
				&& driver.findElement(allOptionInEntriesDropDownMenuOfAllGradesItemOfGrades).isDisplayed()) {
			test.pass("All options of entries dropdown menu are displayed");
		}
		else {
			test.pass("Not all options of entries dropdown menu are displayed");

		}

		driver.findElement(allOptionInEntriesDropDownMenuOfAllGradesItemOfGrades).click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement nextButton = driver.findElement(By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[3]/div[4]/div[2]/ul[1]/li[3]"));

		js.executeScript("arguments[0].scrollIntoView();", nextButton);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		WebElement allEntriesAreDisplayed = driver.findElement(By.cssSelector("li#student_grades_next.paginate_button.next.disabled"));

		Boolean result = allEntriesAreDisplayed.isDisplayed();
		System.out.println(result);
		if(result){
			// Used tests.pass("") command to log the result of the test as "pass" on extent reports.
			test.pass("User can see all her/his exam grades");
			assert(result);
		}
		else {
			// Used tests.fail("") command to log the result of the test as "fail" on extent reports.
			test.fail("The user can not see all her/his exam grades");
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
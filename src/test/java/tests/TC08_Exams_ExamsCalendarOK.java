package tests;

import org.openqa.selenium.By;
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

public class TC08_Exams_ExamsCalendarOK {
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
		htmlReporter = new ExtentHtmlReporter(projectPath + "/TestsReports/TC08_Exams_ExamsCalendarOK.html");
		// Create ExtentReports and attach reporter.
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@Test
	@Parameters({"username", "password"})
	public static void tC08_Exams_ExamsCalendarOK(String username, String password) {
		LogInWebpage logInWebPageObj = new LogInWebpage(driver); 

		// Creates a toggle for the given test, adds all log events under it.    
		ExtentTest test = extent.createTest("TC08: User can selected academic year and the selected date is displayed properly in Month and Year label");

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

		if(homepageObj.isExamsOfCentralMenuDisplayed()){
			// Used tests.pass("") command to log the result of the test as "pass" on extent reports.
			test.pass("Exams of central menu is displayed");
		}
		else {
			// Used tests.fail("") command to log the result of the test as "fail" on extent reports.
			test.fail("Exams of central menu is not displayed");
		}

		homepageObj.clickExamsOfCentralMenu();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		if(homepageObj.isMyExamsOfExamsOfCentralMenuDisplayed() && homepageObj.isExamsCalendarOfExamsOfCentralMenuDisplayed()) {
			test.pass("All menu items of exams choice of central menu item are displayed");
		}
		else {
			test.fail("Not all menu items of exams choice of central menu item are displayed");
		}

		homepageObj.clickExamsCalendarOfExamsOfCentralMenu();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		By syllabusDropDownListElement = By.id("studentCourseSyllabusExamSyllabus");
		driver.findElement(syllabusDropDownListElement).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		By syllabusDropDownListElement2014_2015 = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[2]/select[1]/option[7]");
		By syllabusDropDownListElement2015_2016 = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[2]/select[1]/option[6]");
		By syllabusDropDownListElement2016_2017 = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[2]/select[1]/option[5]");
		By syllabusDropDownListElement2017_2018 = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[2]/select[1]/option[4]");
		By syllabusDropDownListElement2018_2019 = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[2]/select[1]/option[3]");
		By syllabusDropDownListElement2019_2020 = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[2]/select[1]/option[2]");
		By syllabusDropDownListElement2020_2021 = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[2]/select[1]/option[1]");

		if(driver.findElement(syllabusDropDownListElement2014_2015).isDisplayed() && driver.findElement(syllabusDropDownListElement2015_2016).isDisplayed()
				&& driver.findElement(syllabusDropDownListElement2016_2017).isDisplayed() && driver.findElement(syllabusDropDownListElement2017_2018).isDisplayed()
				&& driver.findElement(syllabusDropDownListElement2018_2019).isDisplayed() && driver.findElement(syllabusDropDownListElement2019_2020).isDisplayed()
				&& driver.findElement(syllabusDropDownListElement2020_2021).isDisplayed()) {
			test.pass("All options of Syllabus drop-down list are displayed");
		}
		else {
			test.fail("not all options of Syllabus drop-down list are displayed");
		}

		driver.findElement(syllabusDropDownListElement2018_2019).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		By greenColorLabel = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/p[1]");
		driver.findElement(greenColorLabel).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(greenColorLabel).click();


		By monthLabelAndYearLabel = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[3]");
		String monthLabelAndYearLabelText = driver.findElement(monthLabelAndYearLabel).getText();
		Boolean result = monthLabelAndYearLabelText.contains("2018");
		if (result) {
			test.pass("The selected academic year is  displayed properly in Month and Year label");
			System.out.println("The selected academic year is displayed properly in Month and Year label");
			assert(result);
		}
		else {
			test.fail("The selected academic year is not displayed properly in Month and Year label");
			System.out.println("The selected academic year is not displayed properly in Month and Year label");
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
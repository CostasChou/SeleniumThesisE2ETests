package webpages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Homepage {
	WebDriver driver = null;

	//Web Element locators
	By amDropDownMenu = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[1]/a[1]/span[1]");
	By profileChoiceOfAmDropDownMenu = By.linkText("Προφίλ");
	By userGuideChoiceOfAmDropDownMenu = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[1]/ul[1]/li[2]/a[1]");
	By logOutChoiceOfAmDropDownMenu = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/nav[1]/ul[1]/li[1]/ul[1]/li[3]/a[1]/span[1]");
	By languageDropDownMenu = By.id("localeDropDown");
	By greekChoiceOfDropDownMenu = By.id("elLocale");
	By englishChoiceOfDropDownMenu = By.id("enLocale");
	By userManualMenuItem = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[3]/ul[1]/div[1]/li[13]/a[1]/span[1]");
	By studentDataOfCentralMenu = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[3]/ul[1]/div[1]/li[2]/a[1]");
	By thesesOfCentralMenu = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[3]/ul[1]/div[1]/li[8]/a[1]");
	By gradesOfCentraLMenu = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[3]/ul[1]/div[1]/li[5]/a[1]");
	By myBoardMenuItemOfGrades = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[3]/ul[1]/div[1]/li[5]/ul[1]/li[1]/a[1]");
	By allGradesMenuItemOfGrades = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[3]/ul[1]/div[1]/li[5]/ul[1]/li[2]/a[1]");
	By examPeriodMenuItemOfGrades = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[3]/ul[1]/div[1]/li[5]/ul[1]/li[3]/a[1]");
	By examsOfCentralMenu = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[3]/ul[1]/div[1]/li[7]/a[1]");
	By myExamsChoiceOfExamsOfCentralMenu = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[3]/ul[1]/div[1]/li[7]/ul[1]/li[1]/a[1]");
	By examsCalendrChoiceOfExamsOfCentralMenu = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[3]/ul[1]/div[1]/li[7]/ul[1]/li[2]/a[1]");
	By hamburgerMenuIcon = By.id("menu_toggle");

	//Constructor
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}

	/*Assertions */
	public Boolean isAmButtonDisplayed() {
		Boolean amButtonIsDisplayed = driver.findElement(amDropDownMenu).isDisplayed();
		if(amButtonIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}

	public Boolean isProfilelistItemOfAmButtonDisplayed() {
		Boolean profileListItemOfAmButtonIsDisplayed = driver.findElement(profileChoiceOfAmDropDownMenu).isDisplayed();
		if(profileListItemOfAmButtonIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}

	public Boolean isUserGuidelistItemOfAmButtonDisplayed() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		//specify the WebElement till which the page has to be scrolled
		WebElement element = driver.findElement(By.linkText("Εγχειρίδιο χρήσης"));

		js.executeScript("arguments[0].scrollIntoView();", element);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean userGuidelistItemOfAmButtonIsDisplayed = driver.findElement(logOutChoiceOfAmDropDownMenu).isDisplayed();
		if(userGuidelistItemOfAmButtonIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}

	public Boolean isLogOutlistItemOfAmButtonDislpayed() {
		Boolean logOutlistItemOfAmButtonIsDisplayed = driver.findElement(userGuideChoiceOfAmDropDownMenu).isDisplayed();
		if(logOutlistItemOfAmButtonIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}


	public Boolean isLanguageDropDownMenuDisplayed() {
		Boolean languageDropDownMenuIsDisplayed = driver.findElement(languageDropDownMenu).isDisplayed();
		if(languageDropDownMenuIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}

	public Boolean isGreekChoiceOfDropDownMenuDisplayed() {
		Boolean greekChoiceOfDropDownMenuIsDisplayed = driver.findElement(greekChoiceOfDropDownMenu).isDisplayed();
		if(greekChoiceOfDropDownMenuIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}

	public Boolean isEnglishChoiceOfDropDownMenuDisplayed() {
		Boolean englishChoiceOfDropDownMenuIsDisplayed = driver.findElement(englishChoiceOfDropDownMenu).isDisplayed();
		if(englishChoiceOfDropDownMenuIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}

	public Boolean isLanguageChangedToEnglish() {
		return driver.getPageSource().contains("Welcome to Web Portal");
	}

	public Boolean isLanguageChangedToGreek() {
		return driver.getPageSource().contains("Καλώς ήρθατε στην Πύλη του Φοιτητολογίου");
	}

	public Boolean isUserManualButtonDisplayed() {
		return driver.findElement(userManualMenuItem).isDisplayed();
	}
	
	public Boolean isStudentDataOfCentralMenuDisplayed() {
		Boolean studentDataOfCentralMenuIsDisplayed = driver.findElement(studentDataOfCentralMenu).isDisplayed();
		if(studentDataOfCentralMenuIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean isThesesOfCentralMenuDisplayed() {
		Boolean thesesOfCentralMenuisDisplayed = driver.findElement(thesesOfCentralMenu).isDisplayed();
		if(thesesOfCentralMenuisDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}

	public Boolean isGradesOfCentralMenuDisplayed() {
		Boolean gradesOfCentralMenuIsDisplayed = driver.findElement(gradesOfCentraLMenu).isDisplayed();
		if(gradesOfCentralMenuIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean isMyBoardMenuItemOfGradesDisplayed() {
		Boolean myBoardMenuItemOfGradesIsDisplayed = driver.findElement(myBoardMenuItemOfGrades).isDisplayed();
		if(myBoardMenuItemOfGradesIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean isAllGradesMenuItemOfGradesDisplayed() {
		Boolean allGradesMenuItemOfGradesIsDisplayed = driver.findElement(allGradesMenuItemOfGrades).isDisplayed();
		if(allGradesMenuItemOfGradesIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean isByExamPeriodMenuItemOfGradesDisplayed() {
		Boolean examPeriodMenuItemOfGradesIsDisplayed = driver.findElement(examPeriodMenuItemOfGrades).isDisplayed();
		if(examPeriodMenuItemOfGradesIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean isExamsOfCentralMenuDisplayed() {
		Boolean examsOfCentralMenuIsDisplayed = driver.findElement(examsOfCentralMenu).isDisplayed();
		if(examsOfCentralMenuIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}
	public Boolean isMyExamsOfExamsOfCentralMenuDisplayed() {
		Boolean myExamsOfExamsOfCentralMenuIsDisplayed = driver.findElement(myExamsChoiceOfExamsOfCentralMenu).isDisplayed();
		if(myExamsOfExamsOfCentralMenuIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}
	public Boolean isExamsCalendarOfExamsOfCentralMenuDisplayed() {
		Boolean examsCalendarOfExamsOfCentralMenuIsDisplayed = driver.findElement(examsCalendrChoiceOfExamsOfCentralMenu).isDisplayed();
		if(examsCalendarOfExamsOfCentralMenuIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}
	public Boolean isHamburgerMenuIconDisplayed() {
		Boolean hamburgerMenuIconIsDisplayed = driver.findElement(hamburgerMenuIcon).isDisplayed();
		if(hamburgerMenuIconIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*Actions */	

	public void clickAmDropDownMenu() {
		driver.findElement(amDropDownMenu).click();
	}

	public void clickProfilelistItemOfAmButton() {
		driver.findElement(profileChoiceOfAmDropDownMenu).click();
	}

	public void clickUserByGuidelistItemOfAmButton() {
		driver.findElement(userGuideChoiceOfAmDropDownMenu).click();
	}

	public void clicklogOutlistItemOfAmButton() {
		driver.findElement(logOutChoiceOfAmDropDownMenu).click();
	}

	public void clickLanguageDropDownMenu() {
		driver.findElement(languageDropDownMenu).click();
	}

	public void clickGreekChoiceOfLanguageDropDownMenu() {
		driver.findElement(greekChoiceOfDropDownMenu).click();
	}

	public void clickEnglishChoiceOfLanguageDropDownMenu() {
		driver.findElement(englishChoiceOfDropDownMenu).click();
	}
	
	public void clickUserManualItemOfCentralMenu() {
		driver.findElement(userManualMenuItem).click();
	}
	
	public void clickStudentDataItemOfCentralMenu() {
		driver.findElement(studentDataOfCentralMenu).click();
	}
	
	public void clickThesesItemOfCentralMenu() {
		driver.findElement(thesesOfCentralMenu).click();
	}
	
	public void clickGradesItemOfCentralMenu() {
		driver.findElement(gradesOfCentraLMenu).click();
	}
	public void clickMyBoardMenuItemOfGrades() {
		driver.findElement(myBoardMenuItemOfGrades).click();
	}
	public void clickAllGradesMenuItemOfGrades() {
		driver.findElement(allGradesMenuItemOfGrades).click();
	}
	public void clickByExamPeriodMenuItemOfGrades() {
		driver.findElement(examPeriodMenuItemOfGrades).click();
	}
	public void clickExamsOfCentralMenu() {
		driver.findElement(examsOfCentralMenu).click();
	}
	public void clickMyExamsOfExamsOfCentralMenu() {
		driver.findElement(myExamsChoiceOfExamsOfCentralMenu).click();
	}
	public void clickExamsCalendarOfExamsOfCentralMenu() {
		driver.findElement(examsCalendrChoiceOfExamsOfCentralMenu).click();
	}
	public void clickHamburgerMenuIcon() {
		driver.findElement(hamburgerMenuIcon).click();
	}
}

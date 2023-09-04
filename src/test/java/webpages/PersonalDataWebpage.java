package webpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDataWebpage {
	WebDriver driver = null;

	//Web Element Locators
	By studentDataTabOfStudentDataChoiceOfCentralMenu = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]");
	By personalDataTabOfStudentDataChoiceOfCentralMenu = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[2]");
	By personEntityForm = By.id("personEntityForm");


	//Constructor
	public PersonalDataWebpage(WebDriver driver) {
		this.driver = driver;
	}

	/*Assertions */
	public Boolean isStudentDataTabOfStudentDataChoiceOfCentalMenuDisplayed() {
		Boolean studentDataTabOfStudentDataChoiceOfCentalMenuIsDisplayed = driver.findElement(personalDataTabOfStudentDataChoiceOfCentralMenu).isDisplayed();
		if(studentDataTabOfStudentDataChoiceOfCentalMenuIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}

	public Boolean isPersonalDataTabOfStudentDataChoiceOfCentalMenuDisplayed() {
		Boolean personalDataTabOfStudentDataChoiceOfCentalMenuIsDisplayed = driver.findElement(personalDataTabOfStudentDataChoiceOfCentralMenu).isDisplayed();
		if(personalDataTabOfStudentDataChoiceOfCentalMenuIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean isPersonEntintyFormDisplayed() {
		Boolean personEntintyFormIsDislplayed = driver.findElement(personEntityForm).isDisplayed();
		if(personEntintyFormIsDislplayed) {
			return true;
		}
		else {
			return false;
		}
	}
	

	/*Actions */	
	public void clickStudentDataTabOfStudentDataChoiceOfCentralMenu() {
		driver.findElement(studentDataTabOfStudentDataChoiceOfCentralMenu).click();
	}

	public void clickPersonalDataDataTabOfStudentDataChoiceOfCentralMenu() {
		driver.findElement(personalDataTabOfStudentDataChoiceOfCentralMenu).click();
	}

}

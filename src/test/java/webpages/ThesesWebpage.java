package webpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ThesesWebpage {
	WebDriver driver = null;

	//Web Element Locators
	By thesesItem = By.className("odd");

	//Constructor
	public ThesesWebpage(WebDriver driver) {
		this.driver = driver;
	}

	/*Assertions */
	public Boolean isThesesItemDisplayed() {
		Boolean thesesItemIsDisplayed = driver.findElement(thesesItem).isDisplayed();
		if(thesesItemIsDisplayed) {
			return true;
		}
		else {
			return false;
		}
	}

}

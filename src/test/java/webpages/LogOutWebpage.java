package webpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogOutWebpage {
	WebDriver driver = null;
	
	//Web Element Locators
	By logOutTextField = By.className("banner-heading");

	
	//Constructor
	public LogOutWebpage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Assertions
	public Boolean userIsLoggedOut() {
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.equalsIgnoreCase("https://sso.ihu.gr/logout")) {
			return true;
		}
		else {
			return false;
		}
	}
}

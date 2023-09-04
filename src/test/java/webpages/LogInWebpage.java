package webpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogInWebpage {
	WebDriver driver = null;
	
	//Web Element Locators
	By textField_UserName = By.id("username");
	By textField_Password = By.id("password");
	By button_LogIn = By.id("loginButton");
	
	//Constructor
	public LogInWebpage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Retrieve Locators
	public void visitWebPage(String webpage) {
		driver.get(webpage);
	}

	public void setTextInTextFieldUserName(String text) {
		driver.findElement(textField_UserName).sendKeys(text);
	}
	
	public String getTextOfTextFieldUserName() {
		return driver.findElement(textField_UserName).getAttribute("value");
	}
	
	public void setTextInTextFieldPassword(String text) {
		driver.findElement(textField_Password).sendKeys(text);
	}
	
	public String getTextOfTextFieldPassword() {
		return driver.findElement(textField_Password).getAttribute("value");
	}
	
	public Boolean logInButtonIsDisplayed() {
		return driver.findElement(button_LogIn).isDisplayed();
	}
	
	//Actions
	public void clickLogInButton() {
		driver.findElement(button_LogIn).click();
	}
	
	//Assertions
	public Boolean userIsToLogInScreen() {
		return driver.getPageSource().contains("© 2023 International Hellenic University");
	}
	
	public Boolean userIsLoggedIn() {
		return driver.getPageSource().contains("Προφίλ");
	}
	
}

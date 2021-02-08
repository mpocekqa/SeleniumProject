package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PagesBase{
	WebElement emailInputField;
	WebElement passwordInputField;
	WebElement signInButton;
	WebElement errorLabel;
	
	public LoginPage(WebDriver driver) {
		super.driver = driver;
	}

	public WebElement getEmailInputField() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	public WebElement getErrorLabel() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol"));
	}
	
	public void insertEMail(String eMail) {
		getEmailInputField().sendKeys(eMail);
	}
	
	public void insertPassword(String password) {
		getPasswordInputField().sendKeys(password);
	}
	
}

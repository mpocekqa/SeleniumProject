package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainNavigation extends PagesBase {
	WebElement signInTab;
	WebElement signOutTab;

	public MainNavigation(WebDriver driver) {
		super.driver = driver;
	}

	public WebElement getSignInTab() {
		return driver.findElement(By.className("login"));
	}

	public WebElement getSignOutTab() {
		return driver.findElement(By.className("logout"));
	}

}

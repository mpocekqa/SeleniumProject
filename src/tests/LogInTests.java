package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LogInTests extends TestBase {
	
	@Test
	public void logIn() throws InterruptedException {
		String eMail = readFromExcel.getStringData("Login", 2, 2);
		String password = readFromExcel.getStringData("Login", 3, 2);
		String expectedText = readFromExcel.getStringData("Login", 6, 2);
		String actualText;
		
		signIn(eMail, password);
		
		actualText = mainNavigation.getSignOutTab().getText();
		Assert.assertEquals(actualText, expectedText);
		
	}
	
	@Test
	public void logInWrongCredentials() throws InterruptedException {
		String eMail = readFromExcel.getStringData("Login", 2, 4);
		String password = readFromExcel.getStringData("Login", 3, 4);
		String expectedText = readFromExcel.getStringData("Login", 6, 4);
		String actualText;
		
		signIn(eMail, password);
		actualText = logInPage.getErrorLabel().getText();
		Assert.assertEquals(actualText, expectedText);
		
	}
	
	@Test
	public void logInWrongPassword() throws InterruptedException {
		String eMail = readFromExcel.getStringData("Login", 2, 3);
		String password = readFromExcel.getStringData("Login", 3, 3);
		String expectedText = readFromExcel.getStringData("Login", 6, 3);
		String actualText;
		
		signIn(eMail, password);
		actualText = logInPage.getErrorLabel().getText();
		Assert.assertEquals(actualText, expectedText);
		
	}
	
	@AfterMethod
	public void name() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
	
	public void signIn(String email, String password) throws InterruptedException {
		mainNavigation.getSignInTab().click();
		Thread.sleep(2000);
		logInPage.insertEMail(email);
		Thread.sleep(2000);
		logInPage.insertPassword(password);
		Thread.sleep(2000);
 		logInPage.getSignInButton().click();
		Thread.sleep(2000);
	}
}

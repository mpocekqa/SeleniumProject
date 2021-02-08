package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.LoginPage;
import pages.MainNavigation;

public class TestBase {
	WebDriver driver;
	String basePath;
	MainNavigation mainNavigation;
	LoginPage logInPage;
	ReadFromExcel readFromExcel;
	String filePath;
	
	@BeforeClass
	public void preKlase() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");
		
		filePath = "data/testPlan.xlsx";
		this.readFromExcel = new ReadFromExcel(filePath);
		this.driver = new ChromeDriver();
		this.mainNavigation = new MainNavigation(driver);
		this.logInPage = new LoginPage(driver);
		driver.manage().window().maximize();
		basePath = "http://automationpractice.com/index.php";
		driver.navigate().to(basePath);
	}
	
	@AfterClass
	public void posleKlase() {
		driver.close();
	}
}

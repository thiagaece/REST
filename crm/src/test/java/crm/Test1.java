package crm;

import org.testng.annotations.Test;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import crm.MainPage;
import crm.LoginPage;

public class Test1 {
	
	String driverPath = "C:\\ChromeDriver\\chromedriver.exe";
	WebDriver driver;
	MainPage mainPage;
	LoginPage loginPage;
	
	
  @Test
  public void testCase1() {
	  loginPage = new LoginPage(driver);
	  loginPage.LogintoCRM("thiagaece@gmail.com", "Thiaga1989");
	  
	  mainPage = new MainPage(driver);
	  String textTw = mainPage.setTwitter();
	  Assert.assertEquals("Twitter not set up",textTw);
	  mainPage.clickLogout();
  }


  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("https://ui.freecrm.com/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}

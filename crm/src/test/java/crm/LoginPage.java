package crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	@FindBy(name = "email")
	WebElement mail_id;
	
	@FindBy(name = "password")
	WebElement passwd;
	
	@FindBy(xpath = "(//div[text()='Login'])[1]")
	WebElement Login_Btn;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void sendUsername(String name)
	{
		mail_id.sendKeys(name);
	}
	
	public void sendPasswd(String pass)
	{
		passwd.sendKeys(pass);
	}
	
	public void clickButton()
	{
		Login_Btn.click();
	}
	
	public void LogintoCRM(String username, String passwd)
	{
		this.sendUsername(username);
		this.sendPasswd(passwd);
		this.clickButton();
	}
}

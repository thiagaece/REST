package crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	WebDriver driver;
	
	@FindBy(xpath = "//div[@class = 'ui segment twitter-board no-margin']")
	WebElement twitter;
	
	@FindBy( xpath = "//div[@role='listbox']")
	WebElement settings_icon;
	
	@FindBy(xpath = "//span[text()='Log Out']")
	WebElement logout;
	
	public MainPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String setTwitter() {
		String text = twitter.getText();
		System.out.println(text);
		return text;
		
	}
	
	public void clickLogout()
	{
		settings_icon.click();
		logout.click();
	}
	
}

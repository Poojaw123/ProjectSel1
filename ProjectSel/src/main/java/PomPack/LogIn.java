package PomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn 
{
	
	@FindBy (xpath="//input[@class='_2IX_2- VJZDxU\']")
	WebElement username;
	
	@FindBy (xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy (xpath="(//button[@type='submit'])[2]")
	WebElement submit;
	
	public LogIn(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public void sendUser()
	{
		username.sendKeys("poojawarkhede18@gmail.com");
	}
	public void sendPassword()
	{
		password.sendKeys("18@swami");
	}
	public void clickSubmit()
	{
		submit.click();
	}

	
	

}

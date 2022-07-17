package PomPack;

import java.sql.Driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	WebDriver driver;
	
	@FindBy (xpath="//div[text()='Grocery']")
	WebElement grocery;
	
	@FindBy (xpath="//div[text()='Mobiles']")
	WebElement mobiles;
	
	@FindBy (xpath="//div[text()='Appliances']")
	WebElement appliance;
	
	@FindBy (xpath="//div[text()='Travel']")
	WebElement travel;
	
	@FindBy (xpath="(//div[@class='exehdJ'])[1]")
	WebElement end;
	
	@FindBy (xpath="//div[text()='Logout']")
	WebElement logout;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
		this.driver=driver;
		
	}
	public void clickGrocery()
	{
		grocery.click();
		
	}
	public void clickMobile()
	{
		mobiles.click();
	}
	public void clickAppliance()
	{
		appliance.click();
	}
	public void clickTravel()
	{
		travel.click();
	}
	public void clickend()
	{
		Actions act=new Actions(driver);
		act.moveToElement(end).build().perform();
		
	}
	public void clicklogout()
	{
		logout.click();
	}
	
}

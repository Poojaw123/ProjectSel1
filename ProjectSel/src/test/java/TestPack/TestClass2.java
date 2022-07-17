package TestPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import Browser.Base;
import PomPack.HomePage;
import PomPack.LogIn;

public class TestClass2 
{
	WebDriver driver;
	LogIn log;
	HomePage home;
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
//		System.setProperty("webdriver.chrome.driver","D:\\automation\\chromedriver_win32 (2)\\chromedriver.exe");
//		driver=new ChromeDriver();
		System.out.println(browserName);
		if(browserName.equals("Chrome"))
		{
			driver=Base.openChromeBrowser();
		}
		if(browserName.equals("Firefox"))
		{
			driver=Base.openFirefox();
		}
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		
	}
	@BeforeClass
	public void createPOMObject()
	{
		log=new LogIn(driver);
		home=new HomePage(driver);
	}
	@BeforeMethod
	public void login() throws InterruptedException
	{
		driver.get("https://www.flipkart.com");
		
		log.sendUser();
		log.sendPassword();
		log.clickSubmit();
		Thread.sleep(2000);
	    
		
		
	}
	@Test
	public void openAppliances()
	{
		home.clickAppliance();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
	
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(url, "https://www.flipkart.com/tvs-and-appliances-new-clp-store?fm=neo%2Fmerchandising&iid=M_c8f10026-a49c-4894-a0b2-5054321a47e0_1_372UD5BXDFYS_MC.LO4IWVHA61BX&otracker=hp_rich_navigation_7_1.navigationCard.RICH_NAVIGATION_Appliances_LO4IWVHA61BX&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_7_L0_view-all&cid=LO4IWVHA61BX");
		soft.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	@Test
	public void openFlight()
	{
		home.clickTravel();
		String url=driver.getCurrentUrl();
        String title=driver.getTitle();
       
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(url,"https://www.flipkart.com/travel/flights?param=DTNavIcon&fm=neo%2Fmerchandising&iid=M_669345cd-7adc-401f-ae76-d7531a8ec31d_1_372UD5BXDFYS_MC.V4ZPKTOAO321&otracker=hp_rich_navigation_8_1.navigationCard.RICH_NAVIGATION_Travel_V4ZPKTOAO321&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_8_L0_view-all&cid=V4ZPKTOAO321");
        soft.assertEquals(title,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	@AfterMethod
	public void logout()
	{
		home.clickend();
	    home.clicklogout();
		

	}
	@AfterClass
	public void clearObject()
	{
		log=null;
		home=null;
		
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
		
	}
}

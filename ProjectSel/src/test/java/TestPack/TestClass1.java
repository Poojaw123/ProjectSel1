package TestPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
import Utils.Utility;

public class TestClass1 
{
	WebDriver driver;
	HomePage home;
	LogIn log;
	
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
	public void logIn() throws EncryptedDocumentException, IOException, InterruptedException
	{
		driver.get("https://www.flipkart.com");
		
	
		log.sendUser();
		
		
		log.sendPassword();
		log.clickSubmit();
		Thread.sleep(2000);
	    
		
	}
	@Test
	public void openGrocery()
	{
		home.clickGrocery();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(url,"https://www.flipkart.com/grocery-supermart-store?marketplace=GROCERY&fm=neo%2Fmerchandising&iid=M_638f6e73-081f-485f-9e22-18038fd29bee_2_372UD5BXDFYS_MC.CBUR1Q46W5F1&otracker=hp_rich_navigation_2_2.navigationCard.RICH_NAVIGATION_Grocery_CBUR1Q46W5F1&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_2_L0_view-all&cid=CBUR1Q46W5F1");
		soft.assertEquals(title,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		
	}
	@Test
	public void openMobile()
	{
		home.clickMobile();
		String url=driver.getCurrentUrl();
        String title=driver.getTitle();
        SoftAssert soft=new SoftAssert();
		soft.assertEquals(url,"https://www.flipkart.com/mobile-phones-store?fm=neo%2Fmerchandising&iid=M_c2514fca-b314-4825-97d4-0c13162ebc9c_2_372UD5BXDFYS_MC.ZRQ4DKH28K8J&otracker=hp_rich_navigation_3_2.navigationCard.RICH_NAVIGATION_Mobiles_ZRQ4DKH28K8J&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_3_L0_view-all&cid=ZRQ4DKH28K8J");
		soft.assertEquals(title,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		
		
	}
	@AfterMethod
	public void logOut()
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

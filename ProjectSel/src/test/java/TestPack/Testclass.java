package TestPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomPack.HomePage;
import PomPack.LogIn;

public class Testclass
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","D:\\automation\\chromedriver_win32 (2)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		driver.get("https://www.flipkart.com");
		
		LogIn log=new LogIn(driver);
		log.sendUser();
		log.sendPassword();
		log.clickSubmit();
		Thread.sleep(2000);
		HomePage home=new HomePage(driver);
		home.clickGrocery();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		if(url.equals("https://www.flipkart.com/grocery-supermart-store?marketplace=GROCERY&fm=neo%2Fmerchandising&iid=M_638f6e73-081f-485f-9e22-18038fd29bee_2_372UD5BXDFYS_MC.CBUR1Q46W5F1&otracker=hp_rich_navigation_2_2.navigationCard.RICH_NAVIGATION_Grocery_CBUR1Q46W5F1&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_2_L0_view-all&cid=CBUR1Q46W5F1")|| title.equals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		home.clickend();
		home.clicklogout();

		log=new LogIn(driver);
		log.sendUser();
		log.sendPassword();
		log.clickSubmit();
		Thread.sleep(2000);
		home=new HomePage(driver);
		home.clickMobile();
		url=driver.getCurrentUrl();
        title=driver.getTitle();
		if(url.equals("https://www.flipkart.com/mobile-phones-store?fm=neo%2Fmerchandising&iid=M_c2514fca-b314-4825-97d4-0c13162ebc9c_2_372UD5BXDFYS_MC.ZRQ4DKH28K8J&otracker=hp_rich_navigation_3_2.navigationCard.RICH_NAVIGATION_Mobiles_ZRQ4DKH28K8J&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_3_L0_view-all&cid=ZRQ4DKH28K8J")|| title.equals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		home.clickend();
	    home.clicklogout();
	    
	    log=new LogIn(driver);
		log.sendUser();
		log.sendPassword();
		log.clickSubmit();
		Thread.sleep(2000);
		home=new HomePage(driver);
		home.clickAppliance();
		url=driver.getCurrentUrl();
		title=driver.getTitle();
        
		if(url.equals("https://www.flipkart.com/tvs-and-appliances-new-clp-store?fm=neo%2Fmerchandising&iid=M_c8f10026-a49c-4894-a0b2-5054321a47e0_1_372UD5BXDFYS_MC.LO4IWVHA61BX&otracker=hp_rich_navigation_7_1.navigationCard.RICH_NAVIGATION_Appliances_LO4IWVHA61BX&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_7_L0_view-all&cid=LO4IWVHA61BX")|| title.equals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		home.clickend();
	    home.clicklogout();
	    

	    log=new LogIn(driver);
		log.sendUser();
		log.sendPassword();
		log.clickSubmit();
		Thread.sleep(2000);
		home=new HomePage(driver);
		home.clickTravel();
		url=driver.getCurrentUrl();
        title=driver.getTitle();
       
		if(url.equals("https://www.flipkart.com/travel/flights?param=DTNavIcon&fm=neo%2Fmerchandising&iid=M_669345cd-7adc-401f-ae76-d7531a8ec31d_1_372UD5BXDFYS_MC.V4ZPKTOAO321&otracker=hp_rich_navigation_8_1.navigationCard.RICH_NAVIGATION_Travel_V4ZPKTOAO321&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_8_L0_view-all&cid=V4ZPKTOAO321")|| title.equals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		home.clickend();
	    home.clicklogout();
		driver.close();

		
	}

}

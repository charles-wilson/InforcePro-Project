package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.Home_Page;
import pageObjects.LogIn_Page;



public class PageObjectModel {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://inforcepro.com");
		
		

		driver.manage().window().maximize();
		// Use page Object library now

		Home_Page.lnk_MyAccount(driver).click();

		LogIn_Page.txtbx_UserName(driver).sendKeys("mohitgupta");

		LogIn_Page.txtbx_Password(driver).sendKeys("PAssword@123");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		LogIn_Page.btn_LogIn(driver).click();
        
		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

     Home_Page.lnk_LogOut(driver).click(); 
		
		driver.quit();
	}

}

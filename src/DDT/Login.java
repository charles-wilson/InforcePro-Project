package DDT;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {

WebDriver driver;
	
	@Test(dataProvider="inforceproData")
	public void loginToInforcepro(String username, String password) throws Exception{
	 {
		
		driver=new FirefoxDriver();		
				 	 
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://inforcepro.com/login");
		
	
		driver.findElement(By.id("l_email")).sendKeys(username);
																																																																			
		driver.findElement(By.id("l_password")).sendKeys(password);
		
		driver.findElement(By.xpath("html/body/div[5]/div[2]/form/button")).click();
		
		Thread.sleep(5000);
		
		String title = driver.getTitle();
		System.out.println("Page Title :"+title);
		
		Assert.assertTrue(title.contains("InforcePro"));
		  // getscreenshot();

		 }
	}
/*
    public void getscreenshot() throws Exception 
    {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
            FileUtils.copyFile(scrFile, new File("/home/delhivery/InforcePro/Screenshot.png"));
    }
	*/
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider(name="inforceproData")
	public Object[][] passData() throws Exception
	{
		
		
        return DataHandling.getData();
		
		
	}
}

package automationFramework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import pageObjects.Home_Page;


public class TestDownloadPDF {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		//  Wait For Page To Load
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Navigate to URL
		driver.get("https://inforcepro.com");
	
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='login']/a")).click();
		// Enter UserName
		
		driver.findElement(By.id("l_email")).sendKeys("mohitgupta");
		// Enter Password
		driver.findElement(By.id("l_password")).sendKeys("PAssword@123");
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Click on 'Sign In' button
		driver.findElement(By.xpath("html/body/div[5]/div[2]/form/button")).click();
		//Click on Download PDF of first policy
				
		WebElement download = driver.findElement(By.xpath("//*[@id='row_1086567']/td[9]/a/img"));
		download.click();
		String myWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(myWindowHandle);
		WebElement download1 = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div[2]/form/table/tbody/tr[1]/td/input"));
		download1.click();
		//click on Save file from download pop up
		Robot object=new Robot();
		object.keyPress(KeyEvent.VK_ENTER);

        System.out.println("Downloaded PDF successfully!!");
        
        /*Home_Page.lnk_LogOut(driver).click();*/ 

        driver.close(); 

    }
}

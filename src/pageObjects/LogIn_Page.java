package pageObjects;

import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;

public class LogIn_Page {

	private static WebElement element = null;
	 
    public static WebElement txtbx_UserName(WebDriver driver){
 
         element = driver.findElement(By.id("l_email"));
 
         return element;
 
         }
 
     public static WebElement txtbx_Password(WebDriver driver){
 
         element = driver.findElement(By.id("l_password"));
 
         return element;
 
         }
 
     public static WebElement btn_LogIn(WebDriver driver){
 
         element = driver.findElement(By.xpath("html/body/div[5]/div[2]/form/button"));
 
         return element;
 
         }
 
	
}

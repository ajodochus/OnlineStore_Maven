package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class BaseClass {
	
	private static WebElement element = null;
	public static WebDriver driver;
	public static boolean bResult;
	public  BaseClass(WebDriver driver){
		BaseClass.driver = driver;
		BaseClass.bResult = true;
	}
	


}

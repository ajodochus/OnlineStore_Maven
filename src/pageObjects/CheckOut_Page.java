package pageObjects;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import utility.Log;

public class CheckOut_Page extends BaseClass{
		private static WebElement element;
		public static String sProductName;
		public static String sProductPrice;
     public CheckOut_Page(WebDriver driver){
    	super(driver);
    	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(
				30, SECONDS).pollingEvery(2, SECONDS);

		wait.until(ExpectedConditions.titleIs("Checkout | ONLINE STORE"));
    	}
     
	 public static WebElement txt_ProductPrice() throws Exception{
    	 element = null;
       	try{
       		element= driver.findElement(By.xpath(".//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[4]"));
       		Log.info("Product Price for purchased product is found on the Check Out Page");
       	}catch (Exception e){
       		Log.error("Price for purchased product on Check Out page is not found");
       		throw(e);
       		}
       	return element;
        }
	 
	 public static WebElement txt_ProductName() throws Exception{
    	 element = null;
       	try{
       		element= driver.findElement(By.xpath(".//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[2]/a"));
       		Log.info("Product Name for purchased product is found on the Check Out Page");
       	}catch (Exception e){
       		Log.error("Price for purchased product on Check Out page is not found");
       		throw(e);
       		}
       	return element;
        }
	 
	 public static WebElement btn_Continue() throws Exception{
    	 element = null;
       	try{
       		element= driver.findElement(By.xpath(".//*[@id='checkout_page_container']/div[1]/a/span"));
       		Log.info("Continue button is found on the Check Out Page");
       	}catch (Exception e){
       		Log.error("Continue button on Check Out page is not found");
       		throw(e);
       		}
       	return element;
        }

}

package test.java;

import java.security.Key;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.SearchResultPage;
import utility.Constant;

import utility.Log;
import utility.Utils;


public class ProductSearchTest{
	public WebDriver driver;
	private String sTestCaseName;

	

  @BeforeMethod
  public void beforeMethod() throws Exception {

	  	DOMConfigurator.configure("log4j.xml");
	  	
	  	sTestCaseName = this.toString();
	  	Log.info("TC name A: " + sTestCaseName);
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	Log.info("TC name B: " + sTestCaseName);

		
		// Launching the browser, this will take the Browser Type from Test Data Sheet 
		driver = Utils.OpenFFWithEntryPoint(Constant.URL);
		
		new BaseClass(driver);  
        }
  
  // This is the starting of the Main Test Case
  @Test
  public void verifyProductSearchListResult() throws Exception {
	  
	  

	  try{
		//Search_Action.top_navigation_search("apple");
		  	String searchString = "apple";
		  	SearchResultPage.txt_SearchBox().sendKeys(searchString);
			Log.info("sendkeys: " + searchString + " into TopNav search" );
			SearchResultPage.txt_SearchBox().sendKeys(Keys.ENTER);
			Log.info("Click Enter within Topnav Search");
			Log.info("in der topnavigatin suche nach dem Begriff: " + searchString);
			SearchResultPage.waitForPageLoaded();
			Log.info("SearchPage is present" );
			SearchResultPage.productList().isDisplayed();
			Log.info("container for products is present");
			SearchResultPage.checkProductListAfterProductSearch();
			
			Log.info("test passed");
		
	  }catch (Exception e){


		  Utils.takeScreenshot(driver, sTestCaseName);
		  // This will print the error log message
		  Log.error(e.getMessage());
		  // Again throwing the exception to fail the test completely in the TestNG results
		  throw (e);
	  }
		
  }
		
  // Its time to close the finish the test case		
  @AfterMethod
  public void afterMethod() {
	    // Printing beautiful logs to end the test case
	    Log.endTestCase(sTestCaseName);
	    // Closing the opened driver
	    driver.close();
  		}

}

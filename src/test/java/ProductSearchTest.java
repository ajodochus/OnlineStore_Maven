package test.java;

import java.io.File;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import appModules.Search_Action;
import pageObjects.BaseClass;
import pageObjects.SearchResultPage;
import utility.Constant;

import utility.Log;
import utility.Utils;

public class ProductSearchTest {
	public WebDriver driver;
	private String sTestCaseName;

	@DataProvider(name = "provider")
	public Object[][] searchForWithCount() {
		
		Object[][] retkeyword = { { "tv", 2 }, { "apple", 9 } };
		return (retkeyword);
	}

	@BeforeSuite
	public void beforeMethod() throws Exception {

		// DOMConfigurator.configure("log4j.xml");
		Log.addLogger();

		sTestCaseName = this.toString();
		Log.info("TC name raw: " + sTestCaseName);
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.info("TC name no @...: " + sTestCaseName);

		// Launching the browser, this will take the Browser Type from Test Data
		// Sheet
		driver = Utils.OpenFFWithEntryPoint(Constant.URL);

		new BaseClass(driver);
	}

	// This is the starting of the Main Test Case
	@Test(dataProvider="provider")
	public void verifyProductSearchListResult(String dp_searchString, int dp_count) throws Exception {

		try {
			String searchString = dp_searchString;
			SearchResultPage.top_navigation_search(searchString);
			Log.info("Searchresult for " + dp_searchString + " expects " + dp_count + " products");
			Log.info("In fact,  " + SearchResultPage.getCountProductsAfterSearch().toString() + " products are available");
			Assert.assertTrue("Searchresult should be " + dp_count + " but is " + SearchResultPage.getCountProductsAfterSearch().toString(), SearchResultPage.getCountProductsAfterSearch() == dp_count);
		} catch (Exception e) {

			Utils.takeScreenshot(driver, sTestCaseName);
			// This will print the error log message
			Log.error(e.getMessage());
			// Again throwing the exception to fail the test completely in the
			// TestNG results
			throw (e);
		}

	}



	// Its time to close the finish the test case
	@AfterSuite
	public void afterMethod() {
		// Printing beautiful logs to end the test case
		Log.endTestCase(sTestCaseName);
		// Closing the opened driver
		driver.close();
		Log.closeLogger();

	}

}

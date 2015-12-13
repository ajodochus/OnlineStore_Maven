package test.java;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.BaseClass;
import pageObjects.SearchResultPage;
import utility.Constant;
import utility.Log;
import utility.Utils;

public class ProductSearchTest {
	public WebDriver driver;
	private String sTestCaseName;

	@DataProvider(name = "provider")
	public Object[][] DataProvider_productResultsCount() {
		
		Object[][] retkeyword = { { "tv", 2 }, { "apple", 9 } };
		return (retkeyword);
	}

	@BeforeSuite
	public void beforeMethod() throws Exception {

		Log.addLogger();

		sTestCaseName = this.toString();
		Log.info("TC name raw: " + sTestCaseName);
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.info("TC name no @...: " + sTestCaseName);
		driver = Utils.OpenFFWithEntryPoint(Constant.URL);

		new BaseClass(driver);
	}

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

	@AfterSuite
	public void afterMethod() {
		// Printing beautiful logs to end the test case
		Log.endTestCase(sTestCaseName);
		// Closing the opened driver
		driver.close();
		Log.closeLogger();

	}

}

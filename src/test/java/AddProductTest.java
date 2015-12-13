package test.java;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.CheckOut_Page;
import pageObjects.ProductListing_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import appModules.CheckOut_Action;
import appModules.Confirmation_Action;
import appModules.PaymentDetails_Action;
import appModules.ProductSelect_Action;
import appModules.SignIn_Action;
import appModules.Verification_Action;

public class AddProductTest {
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;

	// Following TestNg Test case pattern, and divided a Test case in to three
	// different part.
	// In Before Method, your code will always be the same for every other test
	// case.
	// In other way before method is your prerequisites of your main Test Case
	@BeforeTest
	public void beforeMethod() throws Exception {

		// Log.addLogger();

	}

	// This is the starting of the Main Test Case
	@Test
	public void main() throws Exception {
		try {
			driver = Utils.OpenFFWithEntryPoint(Constant.URL);
			new BaseClass(driver);
			// SignIn_Action.Execute(iTestCaseRow);

			ProductSelect_Action.productType("Accessories");
			// ProductSelect_Action.productAddToCartAction("Magic Mouse");
			ProductListing_Page.productAddToCard("Magic Mouse");
			ProductListing_Page.PopUpAddToCart.btn_GoToCart().click();
			Utils.waitForElement(CheckOut_Page.btn_Continue());
			CheckOut_Page.btn_Continue().click();

			// CheckOut_Action.Execute();

			PaymentDetails_Action.execute("validCustomer");

			// Confirmation_Action.Execute();

			// Verification_Action.Execute();

			if (BaseClass.bResult == true) {
				Log.info("Test passed");
			} else {
				Log.error("Test failed");
				throw new Exception("Test Case Failed because of Verification");

			}
			Log.endTestCase(sTestCaseName);
			driver.close();
		} catch (Exception e) {

			Log.error(e.getMessage());
			throw (e);
		}

	}

	// Its time to close the finish the test case
	@AfterTest
	public void afterMethod() {

		//
	}

}

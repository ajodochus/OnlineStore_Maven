package appModules;

import org.testng.Reporter;

import pageObjects.PaymentDetails_Page;
import testData.Customer;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

// This is called Modularization, when we club series of actions in to one Module
// For Modular Driven Framework, please see http://www.toolsqa.com/modular-driven/ 
public class PaymentDetails_Action {
	
	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
	// iTestcaseRow is passed as an Argument to this method, so that it can used inside this method
	// For use of Functions & Parameters, please see http://www.toolsqa.com/function-parameters/
	public static void execute(String userRole) throws Exception{
		try{
        	
			Customer customer = new Customer(userRole);
			
			
			/* felder aus Excel bezogen
			String sEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Email);
			String sFirstName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_FirstName);
			String sLastName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_LastName);
			String sAddress = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Address);
			String sCountry = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Country);
			String sCity = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_City);
			String sPhone = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Phone);
			*/
			
			

			PaymentDetails_Page.txt_Email().clear();
			PaymentDetails_Page.txt_Email().sendKeys(customer.getEmail());
			Log.info(customer.getEmail() +" is entered as First Name on the Payment detail page");
			
			
			
			PaymentDetails_Page.txt_FirstName().clear();
			PaymentDetails_Page.txt_FirstName().sendKeys(customer.getFirstName());
			Log.info(customer.getFirstName() +" is entered as First Name on the Payment detail page");
			
			
			PaymentDetails_Page.txt_LastName().clear();
			PaymentDetails_Page.txt_LastName().sendKeys(customer.getLastName());
			Log.info(customer.getLastName() +" is entered as Last Name on the Payment detail page");
			
			
			PaymentDetails_Page.txt_Address().clear();
			PaymentDetails_Page.txt_Address().sendKeys(customer.getAddress());
			Log.info(customer.getAddress() +" is entered as Address on the Payment detail page");
			
			
			PaymentDetails_Page.txt_City().clear();
			PaymentDetails_Page.txt_City().sendKeys(customer.getCity());
			Log.info(customer.getCity() +" is entered as City on the Payment detail page");
			
			
			PaymentDetails_Page.drpdwn_Country(customer.getCountry());
			Log.info(customer.getCountry() +" is Selected as Country on the Payment detail page");
			
			
			PaymentDetails_Page.txt_Phone().clear();
			PaymentDetails_Page.txt_Phone().sendKeys(customer.getPhone());
			Log.info(customer.getPhone() +" is entered as Phone on the Payment detail page");
			
			// This is to check that if the Check box for "Same as Billing address" is not already checked
			if(!PaymentDetails_Page.chkbx_SameAsBillingAdd().isSelected()){
				// It it is unchecked, then check the check box
				PaymentDetails_Page.chkbx_SameAsBillingAdd().click();
				Log.info("Same as Billing address check box is selected on the Payment detail page");
			}
			
			// Clicking on the Purchase button to complete the payment
			PaymentDetails_Page.btn_Purchase().click();
			Log.info("Click action is performed on Purchase button on the Payment detail page");
			
            // This is another type of logging, with the help of TestNg Reporter log
            // This has to be very carefully used, you should only print the very important message in to this
            // This will populate the logs in the TestNG HTML reports
            // I have used this Reporter log just once in this whole module 
			Reporter.log("Payment is successfully perfromed for the purchased product.");
			
	    }catch(Exception e){
			throw(e);
			}
		}
}

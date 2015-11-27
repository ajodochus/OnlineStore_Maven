package appModules;

import org.testng.Reporter;

import pageObjects.BaseClass;
import pageObjects.CheckOut_Page;
import pageObjects.Confirmation_Page;
import pageObjects.Home_Page;
import pageObjects.SearchResultPage;
import utility.Log;

// This is called Modularization, when we club series of actions in to one Module
// For Modular Driven Framework, please see http://www.toolsqa.com/modular-driven/ 
public class Search_Action {
	 // I could have created a Function for it but I keep calculations in Functions and test steps in Module Actions
	 // It could have been avoided and simply put these steps in Test Case, it depends totally on you, everybody has their own choice
	public static void top_navigation_search(String searchString) throws Exception{
		
		BaseClass.txt_SearchBox().sendKeys(searchString);
		Log.info("in der topnavigatin suche nach dem Begriff: " + searchString);
		SearchResultPage.waitForPageLoaded();
    	Log.info("SearchPage is present" );
		

	}

}

package test.java;
import org.testng.annotations.BeforeSuite;

import utility.Log;



public class Setup {
	@BeforeSuite
	public void startLogger(){
		Log.addLogger();
	}
}

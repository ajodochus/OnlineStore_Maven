package test.java;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utility.Log;

public class TearDown {
	@AfterSuite
	public void startLogger(){
		Log.closeLogger();
	}
}

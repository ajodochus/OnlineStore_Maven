package test.java;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utility.Log;

public class TearDownTest {
	
	@AfterSuite
	public void startLogger(){
		Log.closeLogger();
	}
}

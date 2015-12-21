package test.java;
import org.testng.annotations.BeforeSuite;

import utility.Log;



public class SetupTest {
	@BeforeSuite
	public void startLogger(){
		Log.addLogger();
	}
}

package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

public class Constant {
	    //public static final String URL = "http://www.onlinestore.toolsqa.com";
	    public static final String URL = "http://store.demoqa.com/";
	    public static final String Username = "demoqatrash-mail";
	    public static final String Password ="ck2ZvO690IW2";
		public static final String Path_TestData = "bin/testData/";
		public static final String File_TestData = "TestDataNoX.xls";
		public static final String File_LOGGERinit = "logs/logger.log";
		public static final String File_LOGGERwithTimestamp = "logs/logger_" + getTime() + ".log";
		
		
		//Test Data Sheet Columns
		public static final int Col_TestCaseName = 0;	
		public static final int Col_UserName =1 ;
		public static final int Col_Password = 2;
		public static final int Col_Browser = 3;
		public static final int Col_ProductType = 4;
		public static final int Col_ProductNumber = 5;
		public static final int Col_FirstName = 6;
		public static final int Col_LastName = 7;
		public static final int Col_Address = 8;
		public static final int Col_City = 9;
		public static final int Col_Country = 10;
		public static final int Col_Phone = 11;
		public static final int Col_Email = 12;
		public static final int Col_Result = 13;
		public static final String Path_ScreenShot = "bin/screenshots/";
		
	
		
		public static String getTime(){
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			return dateFormat.format(date).toString();
		}
		
		
	}




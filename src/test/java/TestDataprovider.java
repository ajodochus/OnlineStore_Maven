package test.java;


	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Vector;
	import org.testng.Assert;
	import org.testng.annotations.*; 
	import static org.testng.Assert.*;
	import java.util.*;
	public class TestDataprovider {
	@DataProvider(name = "Pass Single Parameter")
	public Object[][] createData() {

	    Object[][] retkeyword={{"One"},
	                        {"Two"},
	                        {"Three"}};
	    return(retkeyword);
	}

	@DataProvider(name = "Passing Two parameters")
	public Object[][] createDataforTest2() {
	 List<String> ls=new ArrayList<String>();
	 ls.add("one expected");
	    ls.add("tv");
	    //ls.add("apple");
	    //ls.add("ios");
	    Object[][] retkeyword={{"tv", ls},
	                        {"Two", ls},
	                        {"Three", ls}};
	    return(retkeyword);
	}

	@DataProvider(name = "Passing Three parameters")
	public Object[][] createDataforTest3() {
	    HashMap hm = new HashMap();
	    hm.put("One", "One Test");
	    hm.put("Two", "Two Test");
	    hm.put("Three", "Three Test");

	 List<String> ls=new ArrayList<String>();
	 ls.add("one expected");
	    ls.add("Three expected");
	    ls.add("two expected");
	    ls.add("four expected");
	    Object[][] retkeyword={{"One", ls, hm},
	                        {"Two", ls, hm},
	                        {"Three", ls, hm}};
	    return(retkeyword);
	}

	//@Test(dataProvider = "Passing Three parameters")
	public void verifyData3(String keyword, ArrayList<String> ls, HashMap hm) 
	{ 
	   System.out.println("Passing 3 parameters to Test");
	   System.out.println("Start Test");
	   System.out.println("Value :"+keyword);
	      Iterator it=ls.iterator();
	      while(it.hasNext())
	      {
	        String value=(String)it.next();
	        System.out.println("Value :"+value +" Hash Map is "+ hm.get(keyword));
	      }
	      System.out.println("End Test");
	} 

	//@Test(dataProvider = "Pass Single Parameter")
	public void verifyData1(String keyword) 
	{ 
	   System.out.println("Passing Single parameter to Test");
	   System.out.println("Start Test");
	      System.out.println("Value :"+keyword);
	      System.out.println("End Test");
	} 

	@Test(dataProvider = "Passing Two parameters")
	public void verifyData2(String keyword, ArrayList<String> ls ) 
	{ 
	   System.out.println("Passing Two parameter to Test");
	   System.out.println("Start Test");
	      System.out.println("Value :"+keyword);
	      Iterator it=ls.iterator();
	      while(it.hasNext())
	      {
	        String value=(String)it.next();
	        System.out.println("Value :"+value);
	      }
	      System.out.println("End Test");
	} 
	 
}

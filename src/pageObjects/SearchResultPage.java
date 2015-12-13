package pageObjects;

import org.apache.tools.ant.taskdefs.Javadoc.PackageName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import bsh.util.Util;
import utility.Utils;
//import bsh.util.Util;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.List;

import utility.Log;

public class SearchResultPage extends BaseClass {
	private static WebElement element = null;
	private static String sPageName;

	static String xPath_TopNav_SearchField = ".//input[@value='Search Products']";
	static String xPath_ProductContainer = ".//div[@id='grid_view_products_page_container']";
	static String xPath_SingleProduct = xPath_ProductContainer
			+ "//div[starts-with(@class, 'product_grid_item product_view')]";

	public SearchResultPage(WebDriver driver) {
		super(driver);
		sPageName = this.toString();
		try {
			sPageName = utility.Utils.getTestCaseName(this.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.info("Klassenname konnte nicht ermittelt werden");
		}
	}

	public static WebElement txt_SearchBox() throws Exception {
		try {
			element = driver.findElement(By.xpath(xPath_TopNav_SearchField));
			Log.info("Searchbox is found on the BaseClass");
		} catch (Exception e) {
			bResult = false;
			Log.error("Searchbox is not found on the BaseClass");
			throw (e);
		}
		return element;
	}

	public static WebElement productList() throws Exception {
		try {
			element = driver.findElement(By.xpath(xPath_ProductContainer));
			Log.info("Div Product list found on: " + sPageName);
		} catch (Exception e) {
			Log.error("Element ProductList found on " + sPageName);
			throw (e);
		}
		return element;
	}

	public static void waitForPageLoaded() throws Exception {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, SECONDS).pollingEvery(2, SECONDS);

			wait.until(ExpectedConditions.titleContains("Search Results"));
			Log.info("Side was loaded, page title contains 'Search Results'");
		} catch (Exception e) {
			Log.error("page title doesn't contain 'Search Results'");

		}
	}

	public static List<WebElement> get_ListWebelements_ProductsOnSearchResultPage() throws Exception {
		// a[starts-with(@href, "buy.php/")]
		// <div class="product_grid_item product_view_89">
		List<WebElement> products = driver.findElements(By.xpath(xPath_SingleProduct));
		Log.info("count products: " + products.size());
		return products;
	}

	public static WebElement lnk_LogOut() throws Exception {
		try {

			Log.info("Log Out link is found on the Home Page");
		} catch (Exception e) {
			Log.error("Log Out link is not found on the Home Page");
			throw (e);
		}
		return element;
	}

	public static void top_navigation_search(String searchString) throws Exception {

		SearchResultPage.txt_SearchBox().sendKeys(searchString);
		Log.info("sendkeys: " + searchString + " into TopNav search");

		SearchResultPage.txt_SearchBox().sendKeys(Keys.ENTER);
		Log.info("Search for: " + searchString + "and Enter");

		SearchResultPage.waitForPageLoaded();
		Log.info("SearchPage is present");

		SearchResultPage.productList().isDisplayed();
		Log.info("container for products is present");

	}

	public static Integer getCountProductsAfterSearch() throws Exception {
		List<WebElement> list = get_ListWebelements_ProductsOnSearchResultPage();
		Integer count = list.size();

		return count;

	}

}

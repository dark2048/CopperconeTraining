package TestNGPackage;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class SearchPageTestOM {
	
	private static WebElement element = null;
	
	

	
	//BUTTONS
	public static WebElement flightsButton(WebDriver driver)
	{
		Reporter.log("Found Flights Button /n");

		return driver.findElement(By.id("tab-flight-tab"));
		
	}
	
	
	public static WebElement searchButton(WebDriver driver)
	{
		try {
			Reporter.log("Found Search Button");
			return driver.findElement(By.xpath(".//*[@id='search-button']"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Reporter.log("Something happened", true);
		}
		return null;
	}
	
	public static void clickSearch(WebDriver driver)
	{
		try {
			searchButton(driver).click();
			Reporter.log("Clicked the Search button", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//FROM DATA
	public static WebElement fromTextBox(WebDriver driver)
	{
		return driver.findElement(By.id("flight-origin"));
	}
	
	public static void enterDataFrom(WebDriver driver, String origin)
	{
		fromTextBox(driver).sendKeys(origin);
	}
	
	//DESTINATION DATA
	
	public static WebElement toTextBox(WebDriver driver)
	{
		return driver.findElement(By.id("flight-destination"));
	}
	
	public static void enterDataTo(WebDriver driver, String destination)
	{
		toTextBox(driver).sendKeys(destination);
	}

}

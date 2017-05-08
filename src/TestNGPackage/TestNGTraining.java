package TestNGPackage;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.AfterTest;
import TestNGPackage.SearchPageTestOM;
import org.apache.commons.lang3.time.StopWatch;
public class TestNGTraining {
	
private WebDriver driver;	
	private StopWatch sw;
	
@DataProvider
public Object[][] dp() {
  return new Object[][] {
    new Object[] { "MTY", "IAH" },
    new Object[] { "MEX", "Seattle" },
  };
}
@BeforeTest
public void beforeTest() {
	sw.start();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Antonio\\workspace\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.expedia.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//action = new Actions(driver);
		driver.manage().window().maximize();
}


@Parameters({"origin", "destination"})
  @Test
  public void fillForm(String origin, String destination) {

	  SearchPageTestOM.flightsButton(driver).click();
	  SearchPageTestOM.enterDataFrom(driver, origin);
	  SearchPageTestOM.enterDataTo(driver, destination);
	  SearchPageTestOM.searchButton(driver).click();
  }



  @AfterTest
  public void afterTest() {
	  System.out.println(sw.getTime());
	  sw.stop();
	  driver.quit();
  }

}

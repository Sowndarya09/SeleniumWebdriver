package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.ExtentManager;


public class StepDefinitions {

	ExtentReports extent = ExtentManager.getInstance();
	ExtentTest test;

	private WebDriver driver;


	@Given("^I want to launch a browser and open url$")				
	public void launchBrowser() throws Throwable							
	{		
		  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		test = extent.createTest("Open Google Homepage"); //Initialization
		System.out.println("This Step open the browser");	
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		test.pass("Launched Browser");
	}		

	@When("^Validate whether page \"([^\"]*)\" is launched successfully$")					
	public void validateUrllaunchedsuccessfully(String expectedTitle) throws Throwable 							
	{		
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);	
		test.pass("Verified the title is: " + expectedTitle);
		driver.close();
		driver.quit();
		extent.flush();
	}

}

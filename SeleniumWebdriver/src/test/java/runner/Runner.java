package runner;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.ExtentManager;

@RunWith(Cucumber.class)				
@CucumberOptions(
					features="src\\test\\resources\\features\\LaunchBrowser.feature",glue={"stepdefinitions"})

public class Runner {

	@BeforeClass
	public static void setUp() {
		
		Date date=new Date();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
		String reportLocation = "Reports/";
		ExtentManager.createInstance(reportLocation + timeStamp + "_Report.html");
		
	}
	
	@AfterClass
	public static void wrapUp() {
		
		
	}
}

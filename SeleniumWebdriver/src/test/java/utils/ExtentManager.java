package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getInstance() {
        if (extent == null) {
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setDocumentTitle("Automation Report");
            htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setReportName("Automation Test Results");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }

	public static void createInstance(String reportname) {
		System.out.println(reportname);
		 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportname);
		 htmlReporter.config().setTheme(Theme.STANDARD);
         htmlReporter.config().setDocumentTitle(reportname);
         htmlReporter.config().setEncoding("utf-8");
         htmlReporter.config().setReportName("Automation Test Results");

         extent = new ExtentReports();
         extent.attachReporter(htmlReporter);
		
	}
}

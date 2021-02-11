package ExtentReport;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.youinfo.base.TestBase;

public class ExtentReporterNG extends TestBase{
	public ExtentReporterNG() throws IOException {
		super();
	
	}
	static ExtentReports extent;
	public static ExtentReports ExtentReportGenerator()
	{
		//String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\index.html");
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Priyank Pathak");
		return extent;
	}

}

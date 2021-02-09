/*
 * package com.yourinfo.ExtentReportListener;
 * 
 * import java.io.File; import java.util.Calendar; import java.util.Date; import
 * java.util.List; import java.util.Map;
 * 
 * import org.testng.IResultMap; import org.testng.ISuite; import
 * org.testng.ISuiteResult; import org.testng.ITestContext; import
 * org.testng.ITestResult; import org.testng.xml.XmlSuite;
 * 
 * import com.relevantcodes.extentreports.ExtentReports; import
 * com.relevantcodes.extentreports.ExtentTest; import
 * com.relevantcodes.extentreports.IReporter; import
 * com.relevantcodes.extentreports.LogStatus;
 * 
 * public abstract class ExtentReporterNG implements IReporter{
 * 
 * private ExtentReports extent;
 * 
 * public void generateReport(List<XmlSuite> XmlSuite, List<ISuite>Suite,String
 * OutputDirectory) { extent = new ExtentReports(OutputDirectory +
 * File.separator + "YourInfo_Extent.html",true);
 * 
 * for(ISuite suite : Suite) { Map<String, ISuiteResult>
 * result=suite.getResults(); for(ISuiteResult r : result.values()) {
 * ITestContext context = r.getTestContext();
 * buildTestNodes(context.getPassedTests(),LogStatus.PASS);
 * buildTestNodes(context.getFailedTests(),LogStatus.FAIL);
 * buildTestNodes(context.getSkippedTests(),LogStatus.SKIP); } }
 * 
 * extent.flush(); extent.close(); }
 * 
 * private void buildTestNodes(IResultMap Test, LogStatus Status) {
 * 
 * ExtentTest test;
 * 
 * if(Test.size()>0) {
 * 
 * for(ITestResult result : Test.getAllResults()) { test =
 * extent.startTest(result.getMethod().getMethodName());
 * 
 * test.setStartedTime(getTime(result.getStartMillis()));
 * test.setStartedTime(getTime(result.getEndMillis()));
 * 
 * for(String group : result.getMethod().getGroups())
 * test.assignCategory(group);
 * 
 * if(result.getThrowable()!=null) { test.log(Status, "Test" +
 * Status.toString().toLowerCase()+"ed");
 * 
 * } extent.endTest(test); } } } private Date getTime(long Millis) {
 * 
 * Calendar calendar = Calendar.getInstance(); calendar.setTimeInMillis(Millis);
 * 
 * return calendar.getTime(); }
 * 
 * 
 * }
 */
//package Utils;
//
//public class ExtentsManager {
//    private static ExtentReports extent;
//
//    public static ExtentReports getInstance() {
//        if (extent == null) {
//            ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
//            reporter.config().setReportName("Login Test Report");
//            reporter.config().setDocumentTitle("Automation Results");
//
//            extent = new ExtentReports();
//            extent.attachReporter(reporter);
//            extent.setSystemInfo("Tester", "Akshata");
//        }
//        return extent;
//    }
//}
//
//}

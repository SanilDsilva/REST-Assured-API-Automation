package utilFunctions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExtentManager {
    ExtentHtmlReporter htmlReporter;
////    S3Upload s3u = new S3Upload();
//    AmazonSESEmail email = new AmazonSESEmail();
//    public static int fCount = 0;
//    public static int pCount = 0;
//    public static int sCount = 0;

    public static ExtentReports extent;
    public static ExtentTest testReport;
    public static String ts = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date());
    public static String fileName = ts.replaceAll("[- :]", "");

    @BeforeTest
    public void startReport() {

        // initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/resources/test-report/" + fileName + ".html");
        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);


        //To add system or environment info by using the setSystemInfo method.
        extent.setSystemInfo("Host Name", "SANIL DSILVA");
        extent.setSystemInfo("Environment", "API AUTOMATION");

        //configuration items to change the look and feel
        //add content, manage tests etc
        htmlReporter.config().setChartVisibilityOnOpen(false);
        htmlReporter.config().setDocumentTitle("TechJini API Automation");
        htmlReporter.config().setReportName("PR API REPORT");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setProtocol(Protocol.HTTPS);
        htmlReporter.config().setCSS("#element::-webkit-scrollbar {display: none;}");
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");


    }

    @AfterMethod
    public void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
//            fCount = fCount + 1;
            testReport.log(Status.FAIL, MarkupHelper.createLabel(" FAIL ", ExtentColor.RED));
//            testReport.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
//            pCount = pCount + 1;
            testReport.log(Status.PASS, MarkupHelper.createLabel(" PASS ", ExtentColor.GREEN));

        } else {
            testReport.log(Status.SKIP, MarkupHelper.createLabel(" SKIP ", ExtentColor.INDIGO));
//            sCount = sCount + 1;
            testReport.skip(result.getThrowable());
        }
    }

    @AfterTest
    public void tearDown() throws IOException {
        //to write or update test information to reporter
        extent.flush();
//        sleep(5000);
//        S3Upload.uploadHtmlFile();
//        AmazonSESEmail.emailSend();
    }
}



package utilFunctions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import javax.annotation.Nullable;
import java.util.Map;

import static utilFunctions.ExtentManager.testReport;

public class LogInfo {
    public static void infoData(String apiResponse, String status, @Nullable String apiData, @Nullable Map<String, String> requestParam) {
        ResponseConstants rs = new ResponseConstants();
//        Map responseConst = rs.responseStatus();
//        testReport.log(Status.INFO, MarkupHelper.createCodeBlock("API Data : > " + apiData));
        testReport.log(Status.INFO,"API Data :" + apiData);
//        testReport.log(Status.INFO, MarkupHelper.createCodeBlock("API Data : > " + apiData));
        testReport.log(Status.INFO,"API Request Parameter : > " + requestParam);
//        testReport.log(Status.INFO, MarkupHelper.createCodeBlock("API Request Parameter : > " + requestParam));
        testReport.log(Status.INFO,"API Response : > " + apiResponse);
//        testReport.log(Status.INFO, MarkupHelper.createCodeBlock("API Response : > " + apiResponse));

        testReport.log(Status.INFO, MarkupHelper.createLabel("Internal Status Code : "+status, ExtentColor.ORANGE));
//        : "+responseConst.get(status)

    }
}

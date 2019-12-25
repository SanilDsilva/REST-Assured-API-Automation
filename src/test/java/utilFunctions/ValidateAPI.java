package utilFunctions;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import org.testng.Assert;

import java.io.IOException;
import java.util.Map;

public class ValidateAPI {
    public static void testAndGenerateReport(String apiResponse, String appData, Map<String, String> requestParam, String status, String filePath, int statusCode, String expectOutput) throws IOException, ProcessingException {
        switch (statusCode) {
            case 200:
                //check the API response with expected result
                if (expectOutput.equals("200")) {
                        if (JsonSchemaValid.validate(apiResponse, filePath + "/response200.json")) {
//                        testReport.log(LogStatus.PASS, "API Response Successfully Fetched");
                        LogInfo.infoData(apiResponse, status, appData, requestParam);
                        Assert.assertTrue(true, "API Response Successfully Fetched");


                    } else {
//                        testReport.log(LogStatus.FAIL, " Something went wrong with API in success response");
                        LogInfo.infoData(apiResponse, status, appData, requestParam);
                        Assert.assertFalse(true, "Something went wrong with API in success response");

                    }
                } else {
//                    testReport.log(LogStatus.FAIL, " Something went wrong with API in success response");
                    LogInfo.infoData(apiResponse, status, appData, requestParam);
                    Assert.assertFalse(true, "Something went wrong with API in success response");

                }
                break;

            case 401:
                if (expectOutput.equals("401")) {
                    if (JsonSchemaValid.validate(apiResponse, "response401.json")) {
//                        testReport.log(LogStatus.PASS, "Unauthorized access");
                        LogInfo.infoData(apiResponse, status, appData, requestParam);
                        Assert.assertTrue(true, "Unauthorized access");



                    } else {
//                        testReport.log(LogStatus.FAIL, " Something went wrong with API response");
                        LogInfo.infoData(apiResponse, status, appData, requestParam);
                        Assert.assertFalse(true, "Something went wrong with API response");


                    }
                } else {
//                    testReport.log(LogStatus.FAIL, " 401 is not possible for this API or Something went wrong with API");
                    LogInfo.infoData(apiResponse, status, appData, requestParam);
                    Assert.assertFalse(true, "401 is not possible for this API or Something went wrong with API");


                }
                break;


            case 400:
                if (expectOutput.equals("400")) {
                    if (JsonSchemaValid.validate(apiResponse, filePath + "/response400.json")) {
//                        testReport.log(LogStatus.PASS, "Invalid Inputs ");
                        LogInfo.infoData(apiResponse, status, appData, requestParam);
                        Assert.assertTrue(true, "Invalid Inputs");


                    } else {
//                        testReport.log(LogStatus.FAIL, "Something went wrong with API for Invalid Inputs ");
                        LogInfo.infoData(apiResponse, status, appData, requestParam);

                        Assert.assertFalse(true, "Something went wrong with API for Invalid Inputs");


                    }
                } else {
//                    testReport.log(LogStatus.FAIL, "Something went wrong with API for Invalid Inputs ");
                    LogInfo.infoData(apiResponse, status, appData, requestParam);
                    Assert.assertFalse(true, "Something went wrong with API for Invalid Inputs");


                }

                break;

            case 409:
                if (expectOutput.equals("409")) {
                    if (JsonSchemaValid.validate(apiResponse, filePath + "/response409.json")) {
//                        testReport.log(LogStatus.PASS, "Invalid Inputs ");
                        LogInfo.infoData(apiResponse, status, appData, requestParam);
                        Assert.assertTrue(true, "Invalid Inputs");


                    } else {
//                        testReport.log(LogStatus.FAIL, "Something went wrong with API ");
                        LogInfo.infoData(apiResponse, status, appData, requestParam);
                        Assert.assertFalse(true, "Something went wrong with API");

//
                    }
                } else {
//                    testReport.log(LogStatus.FAIL, "Something went wrong with API for Invalid Inputs ");
                    LogInfo.infoData(apiResponse, status, appData, requestParam);

                    Assert.assertFalse(true, "Something went wrong with API for Invalid Inputs");

                }

                break;


            case 500:
                if (expectOutput.equals("500")) {
                    if (JsonSchemaValid.validate(apiResponse, "response500.json")) {
                        LogInfo.infoData(apiResponse, status, appData, requestParam);
                        Assert.assertFalse(true, "Server Error");

                    } else {
//                        testReport.log(LogStatus.FAIL, "Server Error ");
                        LogInfo.infoData(apiResponse, status, appData, requestParam);
                        Assert.assertFalse(true, "Server Error");

                    }
                } else {
//                    testReport.log(LogStatus.FAIL, "Server Error ");
                    LogInfo.infoData(apiResponse, status, appData, requestParam);

                    Assert.assertFalse(true, "Server Error");


                }
                break;


        }
    }

    public static void testGetAPIAndGenerateReport(String apiResponse, String status, String filePath, int statusCode) throws IOException, ProcessingException {

        switch (statusCode) {
            case 200:
                //check the API response with expected result
                if (JsonSchemaValid.validate(apiResponse, filePath + "/response200.json")) {
//                    testReport.log(LogStatus.PASS, "API Response Successfully Fetched");
                    Assert.assertTrue(true, "API Response Successfully Fetched");

                    LogInfo.infoData(apiResponse, status, null, null);

                } else {
//                    testReport.log(LogStatus.FAIL, " Something went wrong with API in success response");
                    Assert.assertFalse(true, "Something went wrong with API in success response");

                    LogInfo.infoData(apiResponse, status, null, null);

                }
                break;
            //TODO handel API key validation
            case 401:
            case 400:
            case 500:

//                testReport.log(LogStatus.FAIL, " Something went wrong with API response");
                Assert.assertFalse(true, "Something went wrong with API in success response");

                LogInfo.infoData(apiResponse, status, null, null);


                break;


        }
    }
}

package pokerApi.v2_1;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.JSONException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import serializationClass.GetAPIData;
import serializationClass.PostAPIData;
import utilFunctions.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GetApi extends ExtentManager {

    @Test(dataProvider = "GetAPIDataName", priority = 1)
    public void sampleGetAPI(GetAPIData getData) throws IOException, JSONException, ProcessingException {

        //Convert appData JSONCLASS type to JSONObject and create request parameter
        Map<String, String> requestParam = HashMapConvert.ConvertKeyValue(new Gson().toJson(getData));

        //get expected out for the each data
        String expectOutput = requestParam.get("expected_output");

        //optional/removing parameter from request parameter
//        requestParam.remove("id", null);
//        requestParam.remove("name", null);


        //remove expected output from request parameter
        requestParam.remove("expected_output");

        System.out.println(requestParam);

        //START REPORT GENERATION
        //START API REPORT
        testReport = extent.createTest("Get API Data Report", "All the get api hit and related info shown here");
        String apiEndpoint = "http://127.0.0.1:3000/user";
        testReport.assignCategory(apiEndpoint);


        //HIT PostData200 API
//        Response response = RestAssured.given().contentType(ContentType.JSON).body(requestParam)
//                .headers("ApiKey", API_KEY,
//                        "Authorization", AUTHORIZATION).// Header
//                when().post(API End Point). // API path
//                then().contentType(ContentType.JSON).extract().response();


        //HIT GetData API
        //params(requestParam) : parameter for get API
        Response response = RestAssured.given().params(requestParam)
                .headers("Content-Type", "application/json").// Header
                when().get(apiEndpoint). // API path
                then().contentType(ContentType.JSON).extract().response();






        //Extracting JSON response body of API
        ResponseBody body = response.getBody();
        String apiResponse = body.asString();
        System.out.println(apiResponse);

        String status = FetchStatus.getStatusValue(apiResponse, response.statusCode());
        //FILE PATH : TestData/JsonSchema/UpdateMemberDataSchema/ApproveMemberStatus/
        String filePath = "getAPI";

        //VALIDATE API BY PASSING THESE DATA TO METHOD
        //apiResponse : RESPONSE OF THE API AFTER HITTING API
        //appData.toString() : TO DISPLAY WHAT DATA WE PASS FOR API IN REPORT
        //requestParam : API REQUEST PARAMETER SEND TO API
        //status : INTERNAL RESPONSE STATUS CODE OF EACH API
        //filePath : LOCATION OF THE SCHEMA OF API RESPONSES
        //response.statusCode() :  STATUS CODE AFTER HITTING API
        //expectOutput : EXPECTED STATUS CODE FOR EACH DATA -  THIS WILL BE FETCH ALONG WITH DATA IN THE TIME OF READING DATA
        ValidateAPI.testAndGenerateReport(apiResponse, getData.toString(), requestParam, status, filePath, response.statusCode(), expectOutput);

    }

    //FILE NAME : resources/test-data/api-data/postAPIData.json
    @DataProvider(name = "GetAPIDataName")
    public Object[][] passValidData() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("resources/test-data/api-data/getAPIData.json"));
        JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
        //PostAPIData : data serialization class name
        List<GetAPIData> testData = new Gson().fromJson(dataSet, new TypeToken<List<GetAPIData>>() {
        }.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
    }
}

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
import utilFunctions.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GetApi2 extends ExtentManager {

    @Test
    public void getAPI2() throws IOException, JSONException, ProcessingException {


        //START REPORT GENERATION
        //START API REPORT
        testReport = extent.createTest("Get API Data Report", "All the get api hit without parameter");
        String apiEndpoint = "http://127.0.0.1:3000/users";
        testReport.assignCategory(apiEndpoint);


        //HIT GetData API
        //params(requestParam) : parameter for get API
        Response response = RestAssured.given()
                .headers("Content-Type", "application/json").// Header
                when().get(apiEndpoint). // API path
                then().contentType(ContentType.JSON).extract().response();


        //Extracting JSON response body of API
        ResponseBody body = response.getBody();
        String apiResponse = body.asString();
        System.out.println(apiResponse);

        String status = FetchStatus.getStatusValue(apiResponse, response.statusCode());
        //FILE PATH : TestData/JsonSchema/UpdateMemberDataSchema/ApproveMemberStatus/
        String filePath = "getAPI2";

        //VALIDATE API BY PASSING THESE DATA TO METHOD
        //apiResponse : RESPONSE OF THE API AFTER HITTING API
        //appData.toString() : TO DISPLAY WHAT DATA WE PASS FOR API IN REPORT
        //requestParam : API REQUEST PARAMETER SEND TO API
        //status : INTERNAL RESPONSE STATUS CODE OF EACH API
        //filePath : LOCATION OF THE SCHEMA OF API RESPONSES
        //response.statusCode() :  STATUS CODE AFTER HITTING API
        //expectOutput : EXPECTED STATUS CODE FOR EACH DATA -  THIS WILL BE FETCH ALONG WITH DATA IN THE TIME OF READING DATA
        ValidateAPI.testGetAPIAndGenerateReport(apiResponse, status, filePath, response.statusCode());

    }
}

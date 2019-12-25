package utilFunctions;

import org.json.JSONException;
import org.json.JSONObject;

public class FetchStatus {
    public static String getStatusValue(String apiResponse, int statusCode) throws JSONException {
        //GET THE RESPONSE STATUS CODE TO DISPLAY THE MESSAGE
        JSONObject jsonObj = new JSONObject(apiResponse);
        return  (statusCode==200) ? "NA"
                //jsonObj.getJSONObject("data").getJSONObject("response").getString("status")
                : jsonObj.getJSONObject("error").getString("internalErrorCode");

    }

//    public static String getStatusValueV2_1(String apiResponse, int statusCode) throws JSONException {
//        //GET THE RESPONSE STATUS CODE TO DISPLAY THE MESSAGE
//        JSONObject jsonObj = new JSONObject(apiResponse);
//        return  (statusCode==200) ? jsonObj.getJSONObject("data").getString("status")
//                : jsonObj.getJSONObject("error").getString("status");
//
//    }



}

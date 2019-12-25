package utilFunctions;


public final class Constants {

    private Constants() {
        // restrict instantiation
    }

    public static final String CONTENT_TYPE = "application/json";

//    //    <-----------Dev Server----------------------
//    public static final String SERVERURLV1 = "http://13.127.221.148:9000/api/v1/";
//    public static final String SERVERURLV2 = "http://13.127.221.148:9000/v2/";
//    public static final String USERID = "6";
//    public static final String AUTHORIZATION = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InNhbmlsLmRAdGVjaGppbmkuY29tIiwiaWF0IjoxNTU1NDc5NzkzfQ.SvcPQ6ZCXhy66UitB5KK2YwtObYhr7MIIRgd-1JO7HM";
//    public static final String API_KEY = "f63d58b1646609f3423f4424816301486734c3ddcdd8b7130c646da100803fc0909ce5da8929fd857fd01cd5e2921a4b08e2";
//
////    -------------------------------------------

    //-----------------------Stage Server-----------------------//
    public static final String SERVERURLV1 = "http://54.206.8.33:9000/api/v1/";
    public static final String SERVERURLV2 = "http://54.206.8.33:9000/v2/";
    public static final String SERVERURLV2_1 = "http://54.206.8.33:9000/v2.1/";

    public static final String SERVER_TYPE = "STAGING";
    public static final String SERVER_IP = "54.206.8.33";
    public static final String USERID = "122";
    public static final String AUTHORIZATION = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6InBva2Vycm95YWxlLmFwaUBnbWFpbC5jb20iLCJpYXQiOjE1NjU2MTI4NTV9.B3xWnpmnYouiDzF5AYw-PENB7_1qfXXdgjJGPwveaPU";
    public static final String API_KEY = "f63d58b1646609f3423f4424816301486734c3ddcdd8b7130c646da100803fc0909ce5da8929fd857fd01cd5e2921a4b08e2";

    //-------------------------------------------------------------


    //-----------------------S3 Configurations-----------------------//
    //STAGING SERVER
    public static final String CLIENT_REGION = "ap-southeast-2";
    public static final String BUCKET_NAME = "pokerroyale-staging";
    public static final String S3_PATH = "api_report/";
    public static final String ACCESS_KEY = "AKIA5CPFUKLIMH4ETDNL";
    public static final String SECRET_KEY = "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";
    //-------------------------------------------------------------


    public static final String[] TOEMAILS = {
            "sanil.d@techjini.com"

    };

    public static final String[] TORECIPIENT = {
            "sanil.d@techjini.com"

    };
}
//package utilFunctions;
//
//import com.amazonaws.AmazonServiceException;
//import com.amazonaws.SdkClientException;
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//
//import java.io.File;
//
//import static utilFunctions.Constants.*;
//import static utilFunctions.ExtentManager.fileName;
//
//
//public class S3Upload {
//    public static void uploadHtmlFile() {
//        String FILE_NAME = System.getProperty("user.dir") + "/testReport/APIReport" + fileName + ".html";
//
//        try {
//
//            AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
//            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                    .withCredentials(new AWSStaticCredentialsProvider(credentials)).
//                            withRegion(CLIENT_REGION).disableChunkedEncoding()
//                    .build();
//
//            // Upload a file as a new object with ContentType and title specified.
//            PutObjectRequest request = new PutObjectRequest(BUCKET_NAME, S3_PATH + "APIReport" + fileName + ".html", new File(FILE_NAME));
//            ObjectMetadata metadata = new ObjectMetadata();
//            metadata.setContentType("text/html");
//            metadata.addUserMetadata("x-amz-meta-title", "API Report");
//            request.setMetadata(metadata);
//            s3Client.putObject(request);
//            System.out.println(" +++++++++++ UPLOAD SUCCESSFULLY DONE +++++++++++ ");
//
//        } catch (AmazonServiceException e) {
//            // The call was transmitted successfully, but Amazon S3 couldn't process
//            // it, so it returned an error response.
//            System.out.println(" !!!!!!!!!!! SOMETHING WENT WRONG !!!!!!!!!!! ");
//            e.printStackTrace();
//        } catch (SdkClientException e) {
//            // Amazon S3 couldn't be contacted for a response, or the client
//            // couldn't parse the response from Amazon S3.
//            System.out.println(" !!!!!!!!!!! SOMETHING WENT WRONG !!!!!!!!!!! ");
//            e.printStackTrace();
//        }
//    }
//}

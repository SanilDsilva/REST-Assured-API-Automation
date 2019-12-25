//package utilFunctions;
//
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
//import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
//import com.amazonaws.services.simpleemail.model.*;
//
//import java.io.IOException;
//import java.net.InetAddress;
//import java.util.Arrays;
//import java.util.List;
//
//import static utilFunctions.Constants.*;
//import static utilFunctions.ExtentManager.*;
//
//public class AmazonSESEmail {
//
//    // Replace sender@example.com with your "From" address.
//    // This address must be verified with Amazon SES.
//    static final String FROM = "support@pokerroyale.com";
//
//    // Replace recipient@example.com with a "To" address. If your account
//    // is still in the sandbox, this address must be verified.
//    static final List<String> TO  = Arrays.asList(TOEMAILS);
////    List<String> TO = new ArrayList<>();
//
//
//
//    // The configuration set to use for this email. If you do not want to use a
//    // configuration set, comment the following variable and the
//    // .withConfigurationSetName(CONFIGSET); argument below.
////    static final String CONFIGSET = "ConfigSet";
//
//    // The subject line for the email.
//    static final String SUBJECT = "API Automation Report " + ts + "";
//
//    // The HTML body for the email.
//
//    static String HTMLBODY = "";
//
//    // The email body for recipients with non-HTML email clients.
//    static final String TEXTBODY = "There is an issue while sending the report. Please contact support@poker.com";
//
//
//    public static void htmlContent() throws IOException {
//        HTMLBODY = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
//                "\n" +
//                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\n" +
//                "<head>\n" +
//                "    <!--[if gte mso 9]><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml><![endif]-->\n" +
//                "    <meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\"/>\n" +
//                "    <meta content=\"width=device-width\" name=\"viewport\"/>\n" +
//                "    <!--[if !mso]><!-->\n" +
//                "    <meta content=\"IE=edge\" http-equiv=\"X-UA-Compatible\"/>\n" +
//                "    <!--<![endif]-->\n" +
//                "    <title></title>\n" +
//                "    <!--[if !mso]><!-->\n" +
//                "    <link href=\"https://fonts.googleapis.com/css?family=Ubuntu\" rel=\"stylesheet\" type=\"text/css\"/>\n" +
//                "    <!--<![endif]-->\n" +
//                "    <style type=\"text/css\">\n" +
//                "\t\tbody {\n" +
//                "\t\t\tmargin: 0;\n" +
//                "\t\t\tpadding: 0;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\ttable,\n" +
//                "\t\ttd,\n" +
//                "\t\ttr {\n" +
//                "\t\t\tvertical-align: top;\n" +
//                "\t\t\tborder-collapse: collapse;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t* {\n" +
//                "\t\t\tline-height: inherit;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\ta[x-apple-data-detectors=true] {\n" +
//                "\t\t\tcolor: inherit !important;\n" +
//                "\t\t\ttext-decoration: none !important;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t.ie-browser table {\n" +
//                "\t\t\ttable-layout: fixed;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t[owa] .img-container div,\n" +
//                "\t\t[owa] .img-container button {\n" +
//                "\t\t\tdisplay: block !important;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t[owa] .fullwidth button {\n" +
//                "\t\t\twidth: 100% !important;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t[owa] .block-grid .col {\n" +
//                "\t\t\tdisplay: table-cell;\n" +
//                "\t\t\tfloat: none !important;\n" +
//                "\t\t\tvertical-align: top;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t.ie-browser .block-grid,\n" +
//                "\t\t.ie-browser .num12,\n" +
//                "\t\t[owa] .num12,\n" +
//                "\t\t[owa] .block-grid {\n" +
//                "\t\t\twidth: 900px !important;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t.ie-browser .mixed-two-up .num4,\n" +
//                "\t\t[owa] .mixed-two-up .num4 {\n" +
//                "\t\t\twidth: 300px !important;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t.ie-browser .mixed-two-up .num8,\n" +
//                "\t\t[owa] .mixed-two-up .num8 {\n" +
//                "\t\t\twidth: 600px !important;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t.ie-browser .block-grid.two-up .col,\n" +
//                "\t\t[owa] .block-grid.two-up .col {\n" +
//                "\t\t\twidth: 450px !important;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t.ie-browser .block-grid.three-up .col,\n" +
//                "\t\t[owa] .block-grid.three-up .col {\n" +
//                "\t\t\twidth: 450px !important;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t.ie-browser .block-grid.four-up .col [owa] .block-grid.four-up .col {\n" +
//                "\t\t\twidth: 225px !important;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t.ie-browser .block-grid.five-up .col [owa] .block-grid.five-up .col {\n" +
//                "\t\t\twidth: 180px !important;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t.ie-browser .block-grid.six-up .col,\n" +
//                "\t\t[owa] .block-grid.six-up .col {\n" +
//                "\t\t\twidth: 150px !important;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t.ie-browser .block-grid.seven-up .col,\n" +
//                "\t\t[owa] .block-grid.seven-up .col {\n" +
//                "\t\t\twidth: 128px !important;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t.ie-browser .block-grid.eight-up .col,\n" +
//                "\t\t[owa] .block-grid.eight-up .col {\n" +
//                "\t\t\twidth: 112px !important;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t.ie-browser .block-grid.nine-up .col,\n" +
//                "\t\t[owa] .block-grid.nine-up .col {\n" +
//                "\t\t\twidth: 100px !important;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t.ie-browser .block-grid.ten-up .col,\n" +
//                "\t\t[owa] .block-grid.ten-up .col {\n" +
//                "\t\t\twidth: 60px !important;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t.ie-browser .block-grid.eleven-up .col,\n" +
//                "\t\t[owa] .block-grid.eleven-up .col {\n" +
//                "\t\t\twidth: 54px !important;\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t.ie-browser .block-grid.twelve-up .col,\n" +
//                "\t\t[owa] .block-grid.twelve-up .col {\n" +
//                "\t\t\twidth: 50px !important;\n" +
//                "\t\t}\n" +
//                "\t</style>\n" +
//                "    <style id=\"media-query\" type=\"text/css\">\n" +
//                "\t\t@media only screen and (min-width: 920px) {\n" +
//                "\t\t\t.block-grid {\n" +
//                "\t\t\t\twidth: 900px !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid .col {\n" +
//                "\t\t\t\tvertical-align: top;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid .col.num12 {\n" +
//                "\t\t\t\twidth: 900px !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid.mixed-two-up .col.num3 {\n" +
//                "\t\t\t\twidth: 225px !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid.mixed-two-up .col.num4 {\n" +
//                "\t\t\t\twidth: 300px !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid.mixed-two-up .col.num8 {\n" +
//                "\t\t\t\twidth: 600px !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid.mixed-two-up .col.num9 {\n" +
//                "\t\t\t\twidth: 675px !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid.two-up .col {\n" +
//                "\t\t\t\twidth: 450px !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid.three-up .col {\n" +
//                "\t\t\t\twidth: 300px !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid.four-up .col {\n" +
//                "\t\t\t\twidth: 225px !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid.five-up .col {\n" +
//                "\t\t\t\twidth: 180px !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid.six-up .col {\n" +
//                "\t\t\t\twidth: 150px !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid.seven-up .col {\n" +
//                "\t\t\t\twidth: 128px !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid.eight-up .col {\n" +
//                "\t\t\t\twidth: 112px !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid.nine-up .col {\n" +
//                "\t\t\t\twidth: 100px !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid.ten-up .col {\n" +
//                "\t\t\t\twidth: 90px !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid.eleven-up .col {\n" +
//                "\t\t\t\twidth: 81px !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid.twelve-up .col {\n" +
//                "\t\t\t\twidth: 75px !important;\n" +
//                "\t\t\t}\n" +
//                "\t\t}\n" +
//                "\n" +
//                "\t\t@media (max-width: 920px) {\n" +
//                "\n" +
//                "\t\t\t.block-grid,\n" +
//                "\t\t\t.col {\n" +
//                "\t\t\t\tmin-width: 320px !important;\n" +
//                "\t\t\t\tmax-width: 100% !important;\n" +
//                "\t\t\t\tdisplay: block !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.block-grid {\n" +
//                "\t\t\t\twidth: 100% !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.col {\n" +
//                "\t\t\t\twidth: 100% !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.col>div {\n" +
//                "\t\t\t\tmargin: 0 auto;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\timg.fullwidth,\n" +
//                "\t\t\timg.fullwidthOnMobile {\n" +
//                "\t\t\t\tmax-width: 100% !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.no-stack .col {\n" +
//                "\t\t\t\tmin-width: 0 !important;\n" +
//                "\t\t\t\tdisplay: table-cell !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.no-stack.two-up .col {\n" +
//                "\t\t\t\twidth: 50% !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.no-stack .col.num4 {\n" +
//                "\t\t\t\twidth: 33% !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.no-stack .col.num8 {\n" +
//                "\t\t\t\twidth: 66% !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.no-stack .col.num4 {\n" +
//                "\t\t\t\twidth: 33% !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.no-stack .col.num3 {\n" +
//                "\t\t\t\twidth: 25% !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.no-stack .col.num6 {\n" +
//                "\t\t\t\twidth: 50% !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.no-stack .col.num9 {\n" +
//                "\t\t\t\twidth: 75% !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.video-block {\n" +
//                "\t\t\t\tmax-width: none !important;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.mobile_hide {\n" +
//                "\t\t\t\tmin-height: 0px;\n" +
//                "\t\t\t\tmax-height: 0px;\n" +
//                "\t\t\t\tmax-width: 0px;\n" +
//                "\t\t\t\tdisplay: none;\n" +
//                "\t\t\t\toverflow: hidden;\n" +
//                "\t\t\t\tfont-size: 0px;\n" +
//                "\t\t\t}\n" +
//                "\n" +
//                "\t\t\t.desktop_hide {\n" +
//                "\t\t\t\tdisplay: block !important;\n" +
//                "\t\t\t\tmax-height: none !important;\n" +
//                "\t\t\t}\n" +
//                "\t\t}\n" +
//                "\t</style>\n" +
//                "</head>\n" +
//                "<body class=\"clean-body\" style=\"margin: 0; padding: 0; -webkit-text-size-adjust: 100%; background-color: #FFFFFF;\">\n" +
//                "<!--[if IE]><div class=\"ie-browser\"><![endif]-->\n" +
//                "<table bgcolor=\"#FFFFFF\" cellpadding=\"0\" cellspacing=\"0\" class=\"nl-container\" role=\"presentation\" style=\"table-layout: fixed; vertical-align: top; min-width: 320px; Margin: 0 auto; border-spacing: 0; border-collapse: collapse; mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF; width: 100%;\" valign=\"top\" width=\"100%\">\n" +
//                "    <tbody>\n" +
//                "    <tr style=\"vertical-align: top;\" valign=\"top\">\n" +
//                "        <td style=\"word-break: break-word; vertical-align: top; border-collapse: collapse;\" valign=\"top\">\n" +
//                "            <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color:#FFFFFF\"><![endif]-->\n" +
//                "            <div style=\"background-color:transparent;\">\n" +
//                "                <div class=\"block-grid mixed-two-up\" data-body-width-father=\"900px\" rel=\"col-num-container-box-father\" style=\"Margin: 0 auto; min-width: 320px; max-width: 900px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
//                "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
//                "                        <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:900px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
//                "                        <!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" style=\"background-color:transparent;width:300px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
//                "                        <div class=\"col num4\" data-body-width-son=\"300\" rel=\"col-num-container-box-son\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 300px;\">\n" +
//                "                            <div style=\"width:100% !important;\">\n" +
//                "                                <!--[if (!mso)&(!IE)]><!-->\n" +
//                "                                <div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
//                "                                    <!--<![endif]-->\n" +
//                "                                    <div align=\"left\" class=\"img-container left fixedwidth\" style=\"padding-right: 0px;padding-left: 20px;\">\n" +
//                "                                        <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 20px;\" align=\"left\"><![endif]--><img alt=\"Image\" border=\"0\" class=\"left fixedwidth\" src=\"https://pokerroyale-staging.s3-ap-southeast-2.amazonaws.com/api_report/images/logo.png\" style=\"outline: none; text-decoration: none; -ms-interpolation-mode: bicubic; clear: both; border: 0; height: auto; float: none; width: 100%; max-width: 225px; display: block;\" title=\"Image\" width=\"225\"/>\n" +
//                "                                        <!--[if mso]></td></tr></table><![endif]-->\n" +
//                "                                    </div>\n" +
//                "                                    <!--[if (!mso)&(!IE)]><!-->\n" +
//                "                                </div>\n" +
//                "                                <!--<![endif]-->\n" +
//                "                            </div>\n" +
//                "                        </div>\n" +
//                "                        <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
//                "                        <!--[if (mso)|(IE)]></td><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
//                "                        <div class=\"col num8\" data-body-width-son=\"600\" rel=\"col-num-container-box-son\" style=\"display: table-cell; vertical-align: top; min-width: 320px; max-width: 600px;\">\n" +
//                "                            <div style=\"width:100% !important;\">\n" +
//                "                                <!--[if (!mso)&(!IE)]><!-->\n" +
//                "                                <div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
//                "                                    <!--<![endif]-->\n" +
//                "                                    <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 20px; padding-left: 10px; padding-top: 20px; padding-bottom: 20px; font-family: Tahoma, Verdana, sans-serif\"><![endif]-->\n" +
//                "                                    <div style=\"color:#555555;font-family:'Ubuntu', Tahoma, Verdana, Segoe, sans-serif;line-height:200%;padding-top:20px;padding-right:20px;padding-bottom:20px;padding-left:10px;\">\n" +
//                "                                        <div style=\"font-family: 'Ubuntu', Tahoma, Verdana, Segoe, sans-serif; font-size: 12px; line-height: 24px; color: #555555;\">\n" +
//                "                                            <p style=\"font-size: 12px; line-height: 48px; margin: 0;\"><span style=\"font-size: 24px; color: #333333;\"><strong><span style=\"line-height: 48px; font-size: 24px;\">API REPORT</span></strong></span></p>\n" +
//                "                                        </div>\n" +
//                "                                    </div>\n" +
//                "                                    <!--[if mso]></td></tr></table><![endif]-->\n" +
//                "                                    <!--[if (!mso)&(!IE)]><!-->\n" +
//                "                                </div>\n" +
//                "                                <!--<![endif]-->\n" +
//                "                            </div>\n" +
//                "                        </div>\n" +
//                "                        <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
//                "                        <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
//                "                    </div>\n" +
//                "                </div>\n" +
//                "            </div>\n" +
//                "            <div style=\"background-color:transparent;\">\n" +
//                "                <div class=\"block-grid mixed-two-up\" data-body-width-father=\"900px\" rel=\"col-num-container-box-father\" style=\"Margin: 0 auto; min-width: 320px; max-width: 900px; overflow-wrap: break-word; word-wrap: break-word; word-break: break-word; background-color: transparent;\">\n" +
//                "                    <div style=\"border-collapse: collapse;display: table;width: 100%;background-color:transparent;\">\n" +
//                "                        <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:transparent;\"><tr><td align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:900px\"><tr class=\"layout-full-width\" style=\"background-color:transparent\"><![endif]-->\n" +
//                "                        <!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" style=\"background-color:transparent;width:300px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:0px; padding-bottom:5px;\"><![endif]-->\n" +
//                "                        <div class=\"col num4\" data-body-width-son=\"300\" rel=\"col-num-container-box-son\" style=\"display: table-cell; vertical-align: top; max-width: 320px; min-width: 300px;\">\n" +
//                "                            <div style=\"width:100% !important;\">\n" +
//                "                                <!--[if (!mso)&(!IE)]><!-->\n" +
//                "                                <div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:0px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
//                "                                    <!--<![endif]-->\n" +
//                "                                    <div align=\"center\" class=\"img-container center autowidth fullwidth\" style=\"padding-right: 0px;padding-left: 0px;\">\n" +
//                "                                        <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr style=\"line-height:0px\"><td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\"><![endif]--><img align=\"center\" alt=\"Image\" border=\"0\" class=\"center autowidth fullwidth\" src=\"https://pokerroyale-staging.s3-ap-southeast-2.amazonaws.com/api_report/images/cloud-servers-1.gif\" style=\"outline: none; text-decoration: none; -ms-interpolation-mode: bicubic; clear: both; border: 0; height: auto; float: none; width: 100%; max-width: 300px; display: block;\" title=\"Image\" width=\"300\"/>\n" +
//                "                                        <!--[if mso]></td></tr></table><![endif]-->\n" +
//                "                                    </div>\n" +
//                "                                    <!--[if (!mso)&(!IE)]><!-->\n" +
//                "                                </div>\n" +
//                "                                <!--<![endif]-->\n" +
//                "                            </div>\n" +
//                "                        </div>\n" +
//                "                        <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
//                "                        <!--[if (mso)|(IE)]></td><td align=\"center\" width=\"600\" style=\"background-color:transparent;width:600px; border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent;\" valign=\"top\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 0px; padding-left: 0px; padding-top:5px; padding-bottom:5px;\"><![endif]-->\n" +
//                "                        <div class=\"col num8\" data-body-width-son=\"600\" rel=\"col-num-container-box-son\" style=\"display: table-cell; vertical-align: top; min-width: 320px; max-width: 600px;\">\n" +
//                "                            <div style=\"width:100% !important;\">\n" +
//                "                                <!--[if (!mso)&(!IE)]><!-->\n" +
//                "                                <div style=\"border-top:0px solid transparent; border-left:0px solid transparent; border-bottom:0px solid transparent; border-right:0px solid transparent; padding-top:5px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\">\n" +
//                "                                    <!--<![endif]-->\n" +
//                "                                    <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Arial, sans-serif\"><![endif]-->\n" +
//                "                                    <div style=\"color:#555555;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;line-height:120%;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
//                "                                        <div style=\"font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; line-height: 14px; color: #555555;\">\n" +
//                "                                            <p style=\"font-size: 14px; line-height: 21px; margin: 0;\"><span style=\"font-size: 18px; color: #333333;\">API Automation Script Executed Successfully.!</span></p>\n" +
//                "                                        </div>\n" +
//                "                                    </div>\n" +
//                "                                    <!--[if mso]></td></tr></table><![endif]-->\n" +
//                "                                    <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, Verdana, sans-serif\"><![endif]-->\n" +
//                "                                    <div style=\"color:#555555;font-family:'Ubuntu', Tahoma, Verdana, Segoe, sans-serif;line-height:120%;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
//                "                                        <div style=\"font-family: 'Ubuntu', Tahoma, Verdana, Segoe, sans-serif; font-size: 12px; line-height: 14px; color: #555555;\">\n" +
//                "                                            <p style=\"font-size: 12px; line-height: 21px; margin: 0;\"><span style=\"font-size: 18px; color: #333333;\">Client  :  " + System.getProperty("user.name") + " on " + System.getProperty("os.name") + " from " + InetAddress.getLocalHost().getHostAddress().trim() + "  </span></p>\n" +
//                "                                            <p style=\"font-size: 12px; line-height: 21px; margin: 0;\"><span style=\"font-size: 18px; color: #333333;\">Server  :  " + SERVER_TYPE + "    </span></p>\n" +
//                "                                            <p style=\"font-size: 12px; line-height: 21px; margin: 0;\"><span style=\"font-size: 18px; color: #333333;\">Server IP :  " + SERVER_IP + "   </span></p>\n" +
//                "                                            <p style=\"font-size: 12px; line-height: 26px; margin: 0;\"><span style=\"font-size: 22px;\"><span style=\"color: #339966; font-size: 22px; line-height: 26px;\"><strong>PASS</strong>:</span> <strong>" + 100 * pCount / (pCount + fCount + sCount) + "%</strong>     <span style=\"color: #ff0000; font-size: 22px; line-height: 26px;\"><strong>FAIL</strong>:</span> <strong>" + 100 * fCount / (pCount + fCount + sCount) + "% </strong></span></p>\n" +
//                "                                        </div>\n" +
//                "                                    </div>\n" +
//                "                                    <!--[if mso]></td></tr></table><![endif]-->\n" +
//                "                                    <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; font-family: Tahoma, Verdana, sans-serif\"><![endif]-->\n" +
//                "                                    <div style=\"color:#555555;font-family:'Ubuntu', Tahoma, Verdana, Segoe, sans-serif;line-height:120%;padding-top:10px;padding-right:10px;padding-bottom:10px;padding-left:10px;\">\n" +
//                "                                        <div style=\"font-family: 'Ubuntu', Tahoma, Verdana, Segoe, sans-serif; font-size: 12px; line-height: 14px; color: #555555;\">\n" +
//                "                                            <p style=\"font-size: 12px; line-height: 20px; margin: 0;\"><span style=\"font-size: 17px; mso-ansi-font-size: 18px;\">Need more info.? </span></p>\n" +
//                "                                            <p style=\"font-size: 12px; line-height: 19px; margin: 0;\"><span style=\"font-size: 16px; color: #333399;\"><a href=\"https://pokerroyale-staging.s3-ap-southeast-2.amazonaws.com/api_report/APIReport"+fileName+".html\" rel=\"noopener\" style=\"text-decoration: underline; color: #333399;\" target=\"_blank\">Get Report</a></span></p>\n" +
//                "                                        </div>\n" +
//                "                                    </div>\n" +
//                "                                    <!--[if mso]></td></tr></table><![endif]-->\n" +
//                "                                    <!--[if (!mso)&(!IE)]><!-->\n" +
//                "                                </div>\n" +
//                "                                <!--<![endif]-->\n" +
//                "                            </div>\n" +
//                "                        </div>\n" +
//                "                        <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
//                "                        <!--[if (mso)|(IE)]></td></tr></table></td></tr></table><![endif]-->\n" +
//                "                    </div>\n" +
//                "                </div>\n" +
//                "            </div>\n" +
//                "            <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
//                "        </td>\n" +
//                "    </tr>\n" +
//                "    </tbody>\n" +
//                "</table>\n" +
//                "<!--[if (IE)]></div><![endif]-->\n" +
//                "</body>\n" +
//                "</html>";
//
////        Document doc = Jsoup.parse(HTMLBODY);
//
//
//    }
//
//
//    public static void emailSend() throws IOException {
//        try {
//            htmlContent();
//            AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
//            AmazonSimpleEmailService client =
//                    AmazonSimpleEmailServiceClientBuilder.standard()
//                            .withCredentials(new AWSStaticCredentialsProvider(credentials))
//                            // Amazon SES.
//                            .withRegion(Regions.US_WEST_2).build();
//            SendEmailRequest request = new SendEmailRequest()
//                    .withDestination(
//                            new Destination().withToAddresses(TO))
//                    .withMessage(new Message()
//                            .withBody(new Body()
//                                    .withHtml(new Content()
//                                            .withCharset("UTF-8").withData(HTMLBODY))
//                                    .withText(new Content()
//                                            .withCharset("UTF-8").withData(TEXTBODY)))
//                            .withSubject(new Content()
//                                    .withCharset("UTF-8").withData(SUBJECT)))
//                    .withSource(FROM);
//            client.sendEmail(request);
//            System.out.println("Email sent!");
//
//        } catch (Exception ex) {
//            System.out.println("The email was not sent. Error message: "
//                    + ex.getMessage());
//        }
//    }
//}

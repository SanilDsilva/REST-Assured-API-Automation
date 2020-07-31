# REST Assured API Automation Framework
Rest assured api automation framework for TechJini QA Community


## Installation

Need some of prerequisite tool if we don't have any active API.
<ol>
<li><a href="https://mockoon.com/">Mockoon</a> : API mock tool which run on local</li>
<li>Download the API JSON file and import it from Mockoon Tool
<ul><li><a href="https://github.com/SanilDsilva/REST-Assured-API-Automation/blob/master/projecctDataFiles/API%20Automation.json"> API Backup File
</a></li></ul>
</li>
<li>Run the mockoon API server.</li>
</ol>


## Usage

Check the port number where mockoon is running on machine.
Modify the code according to th port.
Look for the code in <b>src/test/java/pokerApi/v2_1/</b>
```java
String apiEndpoint = "http://127.0.0.1:3000/users";
```
Modify the 127.0.0.1:<b>3000</b> port number if the server is running on other port.


#### Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

Developed By : Sanil Dsilva

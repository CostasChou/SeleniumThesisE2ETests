# SeleniumThesisE2ETests
Selenium project for End to end and UI tests for (https://uniportal.ihu.gr)  

JDK is required to run this project. Download JDK here from the official webpage --> (https://www.oracle.com/java/technologies/downloads/)  
## Note:  
⚠️🚩<u><strong>Tests that require login will not be executed after log in, since the password of my credentials is not pushed for security reasons.</strong></u>  
🚦🚫<u><strong>Test "TC08_Exams_ExamsCalendarΟΚ.java" and "TC9_HamburgerMenuItemsWhenCollapsedΟΚ.java" are failing because of bugs.</strong></u>  

## Project structure:  
- **src\test\java**  --> All Test Scripts are included in this folder.
- **testng.xml**  --> Parameters that are used for tests are included in this file. This file also describes the order in which the tests will be executed
- **pom.xml**  --> All Maven dependencies are included in this file.
- **TestsReports**  --> The test execution report for each test is included in this folder
- **src\test\java\webpages**  --> This folder contains all the Webpages that have been used by tests. Each file represents a webpage and contains its corresponding Web - Element Locators, methods to retrieve Web Elements references, methods to perform actions on the Web Elements, and Assertions on the Web Elements. 


## Test execution :rocket:  
⚠️⚠️⚠️<u><strong>ATTENTION! NOT ALL TESTS SHOULD BE EXECUTED PARALLELY! IF TESTS WILL BE EXECUTED PARALLELY IT WILL POSSIBLY AFFECT THE AVAILABILITY OF (https://uniportal.ihu.gr). PLEASE DO NOT EXECUTE MORE THAN 3 TESTS PARALLELY... To execute the preferred test(s), select the test(s) that you want to execute by leaving uncommented only the tests that you want to execute in "testng.xml" file.Check the screenshot below to see an example. In this example(check screenshot, only the 1st test will be executed)⚠️⚠️⚠️ </strong></u> 
![image](https://github.com/CostasChou/SeleniumThesisE2ETests/assets/97087053/41f836f4-2391-4c25-91ef-3012c53e65ce)    

Tests can be executed by right-clicking on the testng.xml file, selecting "Run as" and then selecting "1 TestNG Suite". 
▶︎ More info about execution:  :computer:
The tests will be executed with the order that is described in "testng.xml" file.
▶︎ Other execution options: :bulb:
The tests will be executed by default on Chrome browser.  
You can change the browser by changing the parameter XML tag in "pom.xml" file -->  <parameter name="browser" value="Chrome"></parameter> . You can chose between Chrome, Firefox and MicrosoftEdge. More details on the screenshot below:
![image](https://github.com/CostasChou/SeleniumThesisE2ETests/assets/97087053/d2790982-c062-4cf5-989c-31248c513a1c)





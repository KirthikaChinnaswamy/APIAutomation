# BestBuy API Automation

Best Buy API is automated using Karate Framework. Karate is the only open-source tool to combine API test-automation, mocks, performance-testing and even UI automation into a single, unified framework. The BDD syntax popularised by Cucumber is language-neutral, and easy for even non-programmers. Assertions and HTML reports are built-in, and you can run tests in parallel for speed.

**Building and Running**

To setup API, follow the steps here -> https://github.com/BestBuy/api-playground

To setup the Automation framework, install below items -
 - Eclipse
- Testng & Maven plugin in Eclipse
- Create tests in feature files with tags declared
- Set the feature file name and the tag to execute in TestRunner.java and run it as TestNG Test

****

**Framework Structure**

 src/test/java/TestRunner - 
 Execution starts from Test Runner file where the user need to specify the feature file and the tags to be executed. 
 
 com.bestbuy.featues
 This folder contains the feature files for all modules.
 
 src/test/resources/TestData
 This folder contains the test data in json format
 
 target/ReportRepo
Cucumber Test reports are generated once the execution is at this folder. Goto the latest report generated and open overview-features.html to review report

****
 
**Video Recording**

Available in the following path -> https://github.com/KirthikaChinnaswamy/BestBuyApiAutomation/blob/main/VideoRecording_APIAutomation.mov.zip

****

**Scenarios Automated**

Automated Services API from Best Buy covering below scenarios - 
- Hit url and verify respose
- Pass ID and verify name in response and vice versa
- Pass no data and verify zero data in response
- Pass invalid id and verify response
- Post new id and verify response

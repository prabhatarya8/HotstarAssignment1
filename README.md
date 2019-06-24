# HotstarAssignment1

This project is based on Page Factory Pattern

POM
   Selenium-Java
   testng
   surefire plugin

Main 
    Base.LaunchDriver class -> this class takes care of the webdriver and Page object Manager class initialization
    helper.Helper class -> this class contains 2 method one for Page scroll and other for data compare
    managers.PageObjectManager class -> this class is responsible for All the pages and helper class initialization 
    pages.homepage -> It includes all the webelement of Homepage and the methods to achive the test goals
    pages.loginPage -> It includes all the webelement of LoginPage and the methods to achive the test goals
 
 resources.drivers -> it contains chrome binary require.
 
 
 Test
    Testcase class -> this class contains all the testcase as mentioned in the Assignment
    
  
  
  Run
  Use mvn clean test -Dsize=5 -Dusername="prabhat.arya8@gmail.com" -Dpassword="prabhat@123"
  All the above mentioned parameters are configurable, so you can pass any size, username  and password of your choice to test
  different scenario with different data
    

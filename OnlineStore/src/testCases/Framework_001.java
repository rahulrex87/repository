package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import appModules.CheckOut_Action;
import appModules.Confirmation_Action;
import appModules.PaymentDetails_Action;
import appModules.ProductSelect_Action;
import appModules.SignIn_Action;
import appModules.Verification_Action;

public class Framework_001{
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
  // Following TestNg Test case pattern, and divided a Test case in to three different part.
  // In Before Method, your code will always be the same for every other test case.
  // In other way before method is your prerequisites of your main Test Case	
  @BeforeMethod
  public void beforeMethod() throws Exception {
	    // Configuring Log4j logs, please see the following posts to learn about Log4j Logging
	    // http://www.toolsqa.com/test-case-with-log4j/
	    // http://www.toolsqa.com/log4j-logging/
	  	DOMConfigurator.configure("log4j.xml");
	  	
	  	// Getting the Test Case name, as it will going to use in so many places
	  	// The main use is to get the TestCase row from the Test Data Excel sheet
	  	sTestCaseName = this.toString();
	  	// From above method we get long test case name including package and class name etc.
	  	// The below method will refine your test case name, exactly the name use have used
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
	  	// Start printing the logs and printing the Test Case name
		Log.startTestCase(sTestCaseName);
		
		// Setting up the Test Data Excel file using Constants variables
		// For Constant Variables please see http://www.toolsqa.com/constant-variables/
		// For setting up Excel for Data driven testing, please see http://www.toolsqa.com/data-driven-testing-excel-poi/
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		// Fetching the Test Case row number from the Test Data Sheet
		// This row number will be feed to so many functions, to get the relevant data from the Test Data sheet 
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		// Launching the browser, this will take the Browser Type from Test Data Sheet 
		driver = Utils.OpenBrowser(iTestCaseRow);
		
		// Initializing the Base Class for Selenium driver
		// Now we do need to provide the Selenium driver to any of the Page classes or Module Actions
		// Will soon write a post on Base Class
		new BaseClass(driver);  
        }
  
  // This is the starting of the Main Test Case
  @Test
  public void main() throws Exception {
	  // Every exception thrown from any class or method, will be catch here and will be taken care off
	  // For Exception handling please see http://www.toolsqa.com/selenium-webdriver/exception-handling-selenium-webdriver/
	  try{
		  
		// Here we are calling the SignIN Action and passing argument (iTestCaseRow)
		// This is called Modularization, when we club series of actions in to one Module
		// For Modular Driven Framework, please see http://www.toolsqa.com/modular-driven/  
		SignIn_Action.Execute(iTestCaseRow);
		
		// This action is to select the Product category from the Top Navigation of the Home Page
		// I have converted this in to a module, as there are so many logics involved in to this selection
		// And it is always a best idea to keep your logics separate from your test case
		ProductSelect_Action.productType(iTestCaseRow);
		
		// This action is to select the Product from the Product Listing Page
		// I have again converted this in to a module, as there are so many logics involved in to this selection
		ProductSelect_Action.productNumber(iTestCaseRow);
		
		// This is to assigning Product Name & Price to the variables from the Check Out page, so that it can be matched later for verification
		CheckOut_Action.Execute();
		
		// Here we are calling the Payment Details Action and passing argument (iTestCaseRow)
		// This action will provide all the personal detail and payment detail on the page and complete the payment for the selected product
		PaymentDetails_Action.execute(iTestCaseRow);
		
		// This is to assigning Product Name & Price to the variables from the Confirmation page, so that it can be matched later for verification
		Confirmation_Action.Execute();
		
		// This is to match the Product Name & Price we have stored in variables of Checkout & Confirmation page 
		Verification_Action.Execute();
		
		// Now your test is about to finish but before that you need to take decision to Pass your test or Fail
		// For selenium your test is pass, as you do not face any exception and you come to the end or you test did not stop anywhere
		// But for you it can be fail, if any of your verification is failed
		// This is to check that if any of your verification during the execution is failed
		if(BaseClass.bResult==true){
			// If the value of boolean variable is True, then your test is complete pass and do this
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
		}else{
			// If the value of boolean variable is False, then your test is fail, and you like to report it accordingly
			// This is to throw exception in case of fail test, this exception will be caught by catch block below
			throw new Exception("Test Case Failed because of Verification");
		}
		
	  // Below are the steps you may like to perform in case of failed test or any exception faced before ending your test 
	  }catch (Exception e){
		  // If in case you got any exception during the test, it will mark your test as Fail in the test result sheet
		  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
		  // If the exception is in between the test, bcoz of any element not found or anything, this will take a screen shot
		  Utils.takeScreenshot(driver, sTestCaseName);
		  // This will print the error log message
		  Log.error(e.getMessage());
		  // Again throwing the exception to fail the test completely in the TestNG results
		  throw (e);
	  }
		
  }
		
  // Its time to close the finish the test case		
  @AfterMethod
  public void afterMethod() {
	    // Printing beautiful logs to end the test case
	    Log.endTestCase(sTestCaseName);
	    // Closing the opened driver
	    driver.close();
  		}

}

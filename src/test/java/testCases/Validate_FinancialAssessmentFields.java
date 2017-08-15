//Test case to check error validation of each field on the Financial Assessment page
package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.FinancialAssessment_Page;
import utility.Constant;
import appModules.Navigation_Action;

public class Validate_FinancialAssessmentFields extends BaseClass{
	
	  @Test(priority=0,description="Test Method to login into the site")
	  public void Login() {
		  	Navigation_Action.Navigate_To_LoginPage(driver);
		  	Navigation_Action.Navigate_To_MainPage(driver, Constant.Email, Constant.Password);
	  } 
	  @Test(priority=1,description="Test Method to navigate to Financial Assessment page")
	  public void NavigateToFinancialAssessmentPage() {
		  	Navigation_Action.Navigate_To_ProfilePage(driver);
		  	Navigation_Action.Navigate_To_FinancialAssessmentPage(driver);
	  }
	  @Test(priority=2,description="Test Method to test the error messages displayed when fields are not set")
	  public void Test_FinancialAssessmentFields() {
		  FinancialAssessment_Page.btn_Update(driver).click();
		  List <WebElement> allErrors = driver.findElements(By.xpath("//div[contains(text(),'This field is required.')]")); 
		  if(allErrors.size()==21){
			  System.out.println("Error validation is working for all financial assessment fields");
		  }
		  
	  }
}
package testCases;

import org.testng.annotations.Test;
import appModules.Limits_Action;
import appModules.Login_Action;
import appModules.Navigation_Action;
import utility.Constant;

public class Validate_Limits extends BaseClass {
	int getMaxPos, getAccBal;
	@Test(priority=0,description="Test Method to login into the site")
	public void Login() {
		Navigation_Action.Navigate_To_LoginPage(driver);
	  	Login_Action.Execute(driver,Constant.Email,Constant.Password);
	}
	@Test(priority=1,description="Test Method to navigate to self exclusion page")
	public void NavigateToPersonalDetailsPage() {
		Navigation_Action.Navigate_To_SecurityPage(driver);
		Navigation_Action.Navigate_To_SelfExclusionPage(driver);
	}
	@Test(priority=2,description="Test Method to test error message when the new amount exceed the current amount")
	public void Test_Exceed_MaxAccountBalance() {
		Limits_Action.checkExMaxAccBal(driver);
	}
	@Test(priority=3,description="Test Method to test whether the update is saved when the new amount less than the current amount")
	public void Test_Lower_MaxAccountBalance() {
		getAccBal = Limits_Action.checkLowMaxAccBal(driver);
	}
	@Test(priority=4,description="Test Method to test error message when the new number exceed the current number")
	public void Test_Exceed_MaxOpenPos() {
		Limits_Action.checkExMaxOpPo(driver);
	}
	@Test(priority=5,description="Test Method to test whether the update is saved when the new number less than the current number")
	public void Test_Lower_MaxOpenPos() {
		getMaxPos = Limits_Action.checkLowMaxOpPo(driver);
	}
	@Test(priority=6,description="Test Method to check is it authenticated and navigate to limits page")
	public void NavigateToLimitsPage() {
		Navigation_Action.Navigate_To_AuthenticationPage(driver);
		//Limits_Action.checkAuth(driver);
		Navigation_Action.Navigate_To_SecurityPage(driver);
		Navigation_Action.Navigate_To_LimitsPage(driver);
	}
	@Test(enabled=false,description="Test Method to check whether the amount displayed correctly")
	public void Test_Limits_MaxAccountBalance() {	
		Limits_Action.limit_accbal(driver, getAccBal);
	}
	@Test(priority=8,description="Test Method to check whether the number displayed correctly")
	public void Test_Limits_MaxOpenPosition() {
		Limits_Action.limit_openpo(driver, getMaxPos);
	}
	@Test(priority=9,description="Test Method to check whether the limits message displayed correctly")
	public void Test_Limits_Message() {
		Limits_Action.test_msg(driver);
	} 
}

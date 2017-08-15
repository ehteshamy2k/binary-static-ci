package testCases;
/*Developed by: Ehtesham
Description: To Test withdrawal token notification
Development start: July 18, 2017
Development end: 
*/

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.Constant;
import appModules.Cashier_Action;
import appModules.Navigation_Action;
import appModules.WithdrawalToken_Action;

public class Validate_WithdrawalToken extends BaseClass {
	
  @Test(enabled=false,description = "Validate withdrawal token")
  public void A_TestWithdrawalNotification() throws InterruptedException {
	  
	  Navigation_Action.Navigate_To_LoginPage(driver);
	  Navigation_Action.Navigate_To_MainPage(driver,Constant.NotificationEmail,Constant.NotificationPassword);
	  Navigation_Action.Navigate_To_Cashier(driver);
	  Cashier_Action.clickWithdraw(driver);
	  Thread.sleep(3000);
	  Navigation_Action.Navigate_To_Mailinator(driver);
	  Thread.sleep(3000);
	  Assert.assertEquals("Verify your withdrawal request - Binary.com",WithdrawalToken_Action.checkEmail(driver));
	  WithdrawalToken_Action.openEmail(driver);
	  WithdrawalToken_Action.readToken(driver);
	  WithdrawalToken_Action.deleteNotification(driver);
	  
  }

}

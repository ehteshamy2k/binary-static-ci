package appModules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import pageObjects.APIToken_Page;
import pageObjects.AuthorisedApplications_page;
import pageObjects.CashierPassword_Page;
import pageObjects.ChangePassword_Page;
import pageObjects.Home_Page;
import pageObjects.Login_History;
import pageObjects.MainAccount_Menu;
import pageObjects.MainMenu_Tab;
import pageObjects.Portfolio_Page;
import pageObjects.Profile_Page;
import pageObjects.ProfitTable_Page;
import pageObjects.Security_Page;
import pageObjects.Statement_Page;

public class Navigation_Action {
		
	public static void Navigate_To_HomePage(WebDriver driver,String URL){
		driver.get(URL); 
	}
	public static void Navigate_To_LoginPage(WebDriver driver){ 
		Home_Page.btn_Login(driver).click();
	}
	public static void Navigate_To_MainPage(WebDriver driver,String Email,String Password){
		Login_Action.Execute(driver,Email,Password);
	}
	public static void Navigate_To_ProfilePage(WebDriver driver){
		MainAccount_Menu.link_MainAccount(driver).click();
		MainAccount_Menu.link_Profile(driver).click();
	}
	public static void Navigate_To_SecurityPage(WebDriver driver){
		MainAccount_Menu.link_MainAccount(driver).click();
		MainAccount_Menu.link_Security(driver).click();
	}
	public static void Navigate_To_FinancialAssessmentPage(WebDriver driver){
		Profile_Page.link_FinancialAssessment(driver).click();
	}
	public static void Navigate_To_PersonalDetailsPage(WebDriver driver){
		Profile_Page.link_PersonalDetails(driver).click();
	}
	public static void Navigate_To_AccountPasswordPage(WebDriver driver){
	    Security_Page.link_AccountPassword(driver).click();
	    Assert.assertTrue(ChangePassword_Page.PageTitle(driver).isDisplayed());
		Assert.assertEquals(ChangePassword_Page.PageTitle(driver).getText(), "Change Password");
	}
	public static void Navigate_To_LogoutPage(WebDriver driver){
		Logout_Action.Execute(driver);
		Assert.assertTrue(Home_Page.btn_Login(driver).isDisplayed());
	}
	public static void Navigate_To_APITokenPage(WebDriver driver){
		Actions builder = new Actions(driver);
		Action clickAPIToken = builder
				.moveToElement(Security_Page.link_APITokenPage(driver))
				.click()
				.build();
		clickAPIToken.perform();
        Assert.assertTrue(APIToken_Page.title_page(driver).isDisplayed());
        APIToken_Action.checkTitle(driver);
    }
    public static void Navigate_To_LoginHistoryPage(WebDriver driver){
		Actions builder = new Actions(driver);
		Action clickLoginHistory = builder
				.moveToElement(Security_Page.link_LoginHistoryPage(driver))
				.click()
				.build();
		clickLoginHistory.perform();
        Assert.assertTrue(Login_History.title_page(driver).isDisplayed());
        LoginHistory_Action.Execute(driver);
    }
    public static void Navigate_To_CashierPasswordPage(WebDriver driver){
        Security_Page.link_CashierPassword(driver).click();
        Assert.assertTrue(CashierPassword_Page.title_page(driver).isDisplayed());
        Assert.assertTrue(CashierPassword_Page.title_form(driver).isDisplayed());
        CashierPassword_Action.checkTitle(driver);
	}
	public static void Navigate_To_AuthenticationPage(WebDriver driver){
		driver.get("https://staging.binary.com/en/user/authenticate.html");
	}
	public static void Navigate_To_LimitsPage(WebDriver driver){
		Security_Page.link_Limits(driver).click();
	}
	public static void Navigate_To_SelfExclusionPage(WebDriver driver){
		Security_Page.link_SelfExclusion(driver).click();
	}
    public static void Navigate_To_AuthorisedApplicationsPage(WebDriver driver){
		Actions builder = new Actions(driver);
		Action clickAuthorizedApps = builder
				.moveToElement(Security_Page.link_AuthorisedApplication(driver))
				.click()
				.build();
		clickAuthorizedApps.perform();
        Assert.assertTrue(AuthorisedApplications_page.title_page(driver).isDisplayed());
        Assert.assertTrue(AuthorisedApplications_page.sub_title(driver).isDisplayed());
    }
    public static void Navigate_To_SelfExclusionPage_ValidateInput(WebDriver driver) {
        MainAccount_Menu.link_MainAccount(driver).click();
        MainAccount_Menu.link_Security(driver).click();
        Security_Page.link_SelfExclusionPage(driver).click();
    }
    public static void Navigate_To_ChangeAPIEndpointPage(WebDriver driver,String URL){
    	driver.get(URL);
    }
    public static void Navigate_To_TradingPage(WebDriver driver){
    	MainMenu_Tab.link_TradeMenu(driver).click();
    	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
    public static void Navigate_To_PortfolioPage(WebDriver driver){
    	MainMenu_Tab.link_Portfolio(driver).click();
    	Assert.assertTrue(Portfolio_Page.txt_Header(driver).getText().equals("Portfolio"));
    }
    public static void Navigate_To_ProfitTablePage(WebDriver driver){
    	MainMenu_Tab.link_ProfitTable(driver).click();
    	Assert.assertTrue(ProfitTable_Page.txt_Header(driver).getText().equals("Profit Table"));
    }
    public static void Navigate_To_StatementPage(WebDriver driver){
    	MainMenu_Tab.link_Statement(driver).click();
    	Assert.assertTrue(Statement_Page.txt_Header(driver).getText().equals("Statement"));
    }
  //go to home page
  	public static void Go_Home_Page(WebDriver driver)
  	{
  	    Home_Page.logo(driver).click();
  	}
  	//navigate to upgrade real account page
  	public static void Navigate_To_UpgradeAccount(WebDriver driver)
  	{
  		Home_Page.link_UpgradeToRealAccount(driver).click();
  	}
}

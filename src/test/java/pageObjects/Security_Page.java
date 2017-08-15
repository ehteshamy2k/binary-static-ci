package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.CommonFunctions;

public class Security_Page {

    private static WebElement element = null;
    //Method to find Login History link
    public static WebElement link_LoginHistoryPage(WebDriver driver)
    {
		element = CommonFunctions.FindElementWithExplicitWait(driver, (By.xpath(".//*[@id='settings_container']/div/div[5]/div[1]/a")));
		return element;
    }
    //Method to find Self Exclusion link
    public static WebElement link_SelfExclusionPage(WebDriver driver)
    {
		element = CommonFunctions.FindElementWithExplicitWait(driver, (By.xpath(".//*[@id='settings_container']/div/div[3]/div[1]/a")));
		return element;
    }
    //Method to find Cashier Password Page
    public static WebElement link_CashierPassword(WebDriver driver)
    {
		element = CommonFunctions.FindElementWithExplicitWait(driver, (By.xpath("//*[@id='settings_container']/div/div[2]/div[1]/a/img")));
		return element;
    }
    public static WebElement link_APITokenPage(WebDriver driver)
    //Method to find API Token Page
    {
		element = CommonFunctions.FindElementWithExplicitWait(driver, (By.xpath(".//*[@id='settings_container']/div/div[6]/div[2]/h4/a")));
		return element;
    }
  //Method to find Authorized Application link
    public static WebElement link_AuthorisedApplication(WebDriver driver)
    {
		element = CommonFunctions.FindElementWithExplicitWait(driver, (By.xpath(".//*[@id='settings_container']/div/div[7]/div[2]/h4/a")));
		return element;
    }
    public static WebElement link_AccountPassword(WebDriver driver)
    {
		element = CommonFunctions.FindElementWithExplicitWait(driver, (By.xpath(".//*[@id='change_password']/div[2]/h4/a")));
		return element;
    }
    //Method to find Limits link
    public static WebElement link_Limits(WebDriver driver)
    {
		element = CommonFunctions.FindElementWithExplicitWait(driver, (By.xpath("//a[contains(text(),'Limits')]")));
		return element;
    }
}

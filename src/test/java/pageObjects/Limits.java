package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.CommonFunctions;

public class Limits {
	private static WebElement element = null;
	//Method to find Maximum account cash balance select field in 
	public static WebElement select_MaxAccCashBal(WebDriver driver){
		element = CommonFunctions.FindElementWithExplicitWait(driver, By.xpath(".//*[@id='content']/div[2]/div[1]/div[1]/div[1]/table/tbody/tr[2]/td[2]"));
		return element;
	}
	//Method to find maximum number of open positions field
	public static WebElement select_MaxOpenPos(WebDriver driver){
		element = CommonFunctions.FindElementWithExplicitWait(driver, By.xpath(".//*[@id='content']/div[2]/div[1]/div[1]/div[1]/table/tbody/tr[1]/td[2]"));
		return element;
	}
	//Method to find the banner message
	public static WebElement select_AuthMsg(WebDriver driver){
		element = CommonFunctions.FindElementWithExplicitWait(driver, By.xpath("//*[@id='msg_notification']/a"));
		return element;
	}
	//Method to find the limits message
	public static WebElement select_LimitMsg_1(WebDriver driver){
		element = CommonFunctions.FindElementWithExplicitWait(driver, By.xpath(".//*[@id='content']/div[2]/div[2]/div/p[1]"));
		return element;
	}
	//Method to find the trading limits here link
	public static WebElement link_TradingLimitsHere(WebDriver driver){
		element = CommonFunctions.FindElementWithExplicitWait(driver, By.xpath(".//*[@id='fully_authenticated']/a"));
		return element;
	}
}

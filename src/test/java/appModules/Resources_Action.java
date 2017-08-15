package appModules;



import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Resources_Page;
import utility.ListsUtil;


public class Resources_Action {

    //Method to check title
    public static void checkTitle(WebDriver driver) {
        String j= Resources_Page.title_page(driver).getText();
        System.out.println("Result : "+ j);
        Assert.assertEquals("Resources",j); 
    }
    public static void link_AssetIndex(WebDriver driver) {
        //Method go to Trading Times Asset Index
        Resources_Page.link_AssetIndex(driver).click();
    }
    public static void link_TradingTimes(WebDriver driver) {
        //Method go to Trading Times
        Resources_Page.link_TradingTimes(driver).click();
    }
    public static void checkMarket(WebDriver driver) {
        String[] expectedList = {"Forex","Indices","OTC Stocks","Commodities","Volatility Indices"};
        List<WebElement> actualList = Resources_Page.asset_list(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void checkMarketTradingTimes(WebDriver driver) {
        String[] expectedList = {"Forex","Indices","OTC Stocks","Commodities","Volatility Indices"};
        List<WebElement> actualList = Resources_Page.asset_listTradingTimes(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }

    public static void checkMajorPairs(WebDriver driver) {
        String[] expectedList = {"AUD/JPY","AUD/USD","EUR/AUD","EUR/CAD","EUR/CHF","EUR/GBP","EUR/JPY","EUR/USD","GBP/AUD","GBP/JPY","GBP/USD","USD/CAD","USD/CHF","USD/JPY"};
        List<WebElement> actualList = Resources_Page.list_MajorPairsUnderlying(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void checkMinorPairs(WebDriver driver) {
        String[] expectedList = {"AUD/CAD","AUD/CHF","AUD/NZD","AUD/PLN","EUR/NZD","GBP/CAD","GBP/CHF","GBP/NOK","GBP/NZD","GBP/PLN","NZD/JPY","NZD/USD","USD/MXN","USD/NOK","USD/PLN","USD/SEK"};
        List<WebElement> actualList = Resources_Page.list_MinorPairsUnderlying(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void checkSmartFx(WebDriver driver) {
        String[] expectedList ={"AUD Index","EUR Index","GBP Index","USD Index"}; 
        List<WebElement> actualList = Resources_Page.list_SmartFxUnderlying(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void checkAsiaOceaniaUnderlying(WebDriver driver) {
        String[] expectedList ={"Australian Index","Bombay Index","Hong Kong Index","Jakarta Index","Japanese Index","Singapore Index"}; 
        List<WebElement> actualList = Resources_Page.list_AsiaOceaniaUnderlying(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void checkEuropeAfricaUnderlying(WebDriver driver) {
        String[] expectedList ={"Belgian Index","Dutch Index","French Index","German Index","Irish Index","Norwegian Index","South African Index","Swiss Index"}; 
        List<WebElement> actualList = Resources_Page.list_EuropeAfricaUnderlying(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void checkOTCIndices(WebDriver driver) {
        String[] expectedList ={"Australian OTC Index","Belgian OTC Index","Bombay OTC Index","Dutch OTC Index","French OTC Index","German OTC Index","Hong Kong OTC Index","Istanbul OTC Index","Japanese OTC Index","UK OTC Index","US OTC Index","US Tech OTC Index","Wall Street OTC Index"}; 
        List<WebElement> actualList = Resources_Page.list_OTCIndices(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void checkAmericaIndices(WebDriver driver) {
       Assert.assertEquals("US Index",Resources_Page.IndicesAmerica(driver).getText());
    }
    public static void checkMiddleEastIndices(WebDriver driver) {
        Assert.assertEquals("Dubai Index",Resources_Page.IndicesMiddleEast(driver).getText());
     }
    public static void checkGermanyStocks(WebDriver driver) {
        String[] expectedList ={"Airbus","Allianz","BMW","Daimler","Deutsche Bank","Novartis","SAP","Siemens"};
        List<WebElement> actualList = Resources_Page.list_GermanyStocks(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void checkIndiaStocks(WebDriver driver) {
        String[] expectedList ={"Bharti Airtel","Maruti Suzuki","Reliance Industries","Tata Steel"};
        List<WebElement> actualList = Resources_Page.list_IndiaStocks(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void checkUKStocks(WebDriver driver) {
        String[] expectedList ={"BP","Barclays","British American Tobacco","HSBC","Lloyds Bank","Rio Tinto","Standard Chartered","Tesco"};
        List<WebElement> actualList = Resources_Page.list_UKStocks(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void checkUSStocks(WebDriver driver) {
        String[] expectedList ={"Alibaba","Alphabet","Amazon.com","American Express","Apple","Berkshire Hathaway","Boeing","Caterpillar",
                "Citigroup","Electronic Arts","Exxon Mobil","Facebook","Goldman Sachs","IBM","Johnson & Johnson","MasterCard","McDonald's","Microsoft",
                "PepsiCo","Procter & Gamble"};
        List<WebElement> actualList = Resources_Page.list_USStocks(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void checkMetalCOMM(WebDriver driver) {
        String[] expectedList ={"Gold/USD","Palladium/USD","Platinum/USD","Silver/USD"};
        List<WebElement> actualList = Resources_Page.list_MetalCOMM(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void checkEnergyCOMM(WebDriver driver) {
        Assert.assertEquals("Oil/USD",Resources_Page.energyCOMM(driver).getText());
     }
    public static void checkCIVol(WebDriver driver) {
        String[] expectedList ={"Volatility 10 Index","Volatility 100 Index","Volatility 25 Index","Volatility 50 Index","Volatility 75 Index"};
        List<WebElement> actualList = Resources_Page.list_CIVol(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void checkDailyVol(WebDriver driver) {
        String[] expectedList ={"Bear Market Index","Bull Market Index"};
        List<WebElement> actualList = Resources_Page.list_DailyVol(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void clickNext(WebDriver driver , int i) {
        List<WebElement> NextMarket = Resources_Page.asset_list(driver);
        NextMarket.get(i).click();
    }
    public static void checkFinancialMarket(WebDriver driver) {
        String[] expectedList = {"Forex","Indices","OTC Stocks","Commodities"};
        List<WebElement> actualList = Resources_Page.asset_list(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void checkFinancialMarketTradingTimes(WebDriver driver) {
        String[] expectedList = {"Forex","Indices","OTC Stocks","Commodities"};
        List<WebElement> actualList = Resources_Page.asset_listTradingTimes(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void checkGamingMarket(WebDriver driver) {
        String[] expectedList = {"Volatility Indices"};
        List<WebElement> actualList = Resources_Page.asset_list(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
    public static void checkGamingMarketTradingTimes(WebDriver driver) {
        String[] expectedList = {"Volatility Indices"};
        List<WebElement> actualList = Resources_Page.asset_listTradingTimes(driver);
        ListsUtil.compareWebElementList(expectedList, actualList);
    }
}

package testCases;

import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utility.Constant;
import com.browserstack.local.Local;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class BaseClass {
	
	WebDriver driver;
	 private Local l;
	 
	@BeforeClass

	@org.testng.annotations.Parameters(value={"config", "environment"})
    public void setupApplication(String config_file, String environment) throws Exception {
		
		if (Constant.browser == "local"){
		    	
				ChromeDriverManager.getInstance().setup();
		    	Map<String, Object> prefs = new HashMap<String, Object>();
		    	prefs.put("profile.default_content_setting_values.notifications", 2);
		        prefs.put("credentials_enable_service", false);
		        prefs.put("profile.password_manager_enabled", false);
		    	ChromeOptions options = new ChromeOptions();
		    	options.setExperimentalOption("prefs", prefs);
		    	options.addArguments("start-maximized");//workaround for driver.manage().window.maximize() as it breaks on Chrome 60x on TravisCI
		    	driver = new ChromeDriver(options); 
		    	//driver.manage().window().maximize();
		    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    	driver.get(Constant.URL);
		    	
		}
		else{
			
	    
		        JSONParser parser = new JSONParser();
		        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + config_file));
		        JSONObject envs = (JSONObject) config.get("environments");

		        DesiredCapabilities capabilities = new DesiredCapabilities();

		        Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
		        Iterator it = envCapabilities.entrySet().iterator();
		        while (it.hasNext()) {
		            Map.Entry pair = (Map.Entry)it.next();
		            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
		        }
		        
		        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
		        it = commonCapabilities.entrySet().iterator();
		        while (it.hasNext()) {
		            Map.Entry pair = (Map.Entry)it.next();
		            if(capabilities.getCapability(pair.getKey().toString()) == null){
		                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
		            }
		        }

		        String username = System.getenv("BROWSERSTACK_USERNAME");
		        if(username == null) {
		            username = (String) config.get("user");
		        }

		        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
		        if(accessKey == null) {
		            accessKey = (String) config.get("key");
		        }

		        if(capabilities.getCapability("browserstack.local") != null && capabilities.getCapability("browserstack.local") == "true"){
		            l = new Local();
		            Map<String, String> options = new HashMap<String, String>();
		            options.put("key", accessKey);
		            l.start(options);
		        }

		        driver = new RemoteWebDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);
		        driver.get(Constant.URL);
    		}
		}

	
	  @AfterClass
	  public void closeApplication() {
		  driver.quit();
	  }
}
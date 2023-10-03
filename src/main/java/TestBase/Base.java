package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import GreenCart_Pages.CheckoutPage;
import GreenCart_Pages.HomePage;
import GreenCart_Pages.Negative_ScenarioPage;
import Utilities.LogUtil;
import Utilities.TestUtil;

public class Base {
	/***webdriver initialilize***/
	public static WebDriver driver;
	public static Properties prop; 
	public HomePage homePage;
	public CheckoutPage checkout;
	public Negative_ScenarioPage negative;
	
	/***Initializing logger***/
	public static Logger LogObj = LogManager.getLogger(LogUtil.class);
	
	/***Read Configure Properties***/
	public Base(){ 
		
		try {
		
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./src/test/resources/configure.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 @BeforeMethod
	    public void setUp() {
		 homePage = new HomePage();
	        checkout = new CheckoutPage();
	        negative = new Negative_ScenarioPage();
	        /*Initialize the Browser*/
	        driver.get(prop.getProperty("base_Url"));
	        
	    }

/***Browser initilization Before Suite***/
@BeforeSuite
	public static void initialization(){ 
	LogObj.info("=====================SELENIUM AUTOMATION TEST CASES========================\n");
	
	String browserName = prop.getProperty("browser");  
	
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions option = new ChromeOptions();
			driver = new ChromeDriver(option);
		}
		else if(browserName.equals("ChromeHeadlessMode")){
			ChromeOptions option = new ChromeOptions();
			option.addArguments("headless");
			driver = new ChromeDriver(option);
		}
        else if(browserName.equalsIgnoreCase("edge")) {
        	EdgeOptions edgeOptions = new EdgeOptions();
        	driver = new EdgeDriver(edgeOptions);
        }
        else if(browserName.equals("EdgeHeadlessMode")){
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--headless");
			driver = new EdgeDriver(edgeOptions);
		}
        else if(browserName.equalsIgnoreCase("firefox")) {
        	driver= new FirefoxDriver();
        }
        else if(browserName.equals("FireFoxHeadlessMode")){
			FirefoxOptions firefox = new FirefoxOptions();
			firefox.addArguments("--headless");
			driver = new FirefoxDriver(firefox);
		}
        else
        	System.out.println("No browser found");
		
		LogObj.info("******Open the Browser*****\n");
		/*maximize the Window*/
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
	
		/***Imlicit Wait or Page Loadtimeout***/
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
	}

 /***Close the Browser***/
@AfterSuite

	public static void email() {
		driver.quit();
		LogObj.info("******Close the Browser*****\n");
	   } 


}





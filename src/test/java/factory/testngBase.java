package factory;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j


public class testngBase {

	public static WebDriver driver;
	//public WebDriver driver;// parallel testing
	public Logger logger;
	static Properties p;
	static ChromeOptions options=new ChromeOptions();
	static EdgeOptions options1=new EdgeOptions();
	
	
	@BeforeTest(groups= {"smoke","regression"})
	@Parameters({"browser"})
	public static WebDriver setup(String br) throws IOException
	
	{
		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		
			
		 if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
			{
				DesiredCapabilities capabilities = new DesiredCapabilities();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-blink-features=AutomationControlled");
				options1.addArguments("--disable-blink-features=AutomationControlled");
				
				//os
				if (p.getProperty("os").equalsIgnoreCase("windows")) {
					options.addArguments("--disable-blink-features=AutomationControlled");
				    capabilities.setPlatform(Platform.WIN11);
				} else if (p.getProperty("os").equalsIgnoreCase("mac")) {
					options.addArguments("--disable-blink-features=AutomationControlled");
				    capabilities.setPlatform(Platform.MAC);
				} else {
				    System.out.println("No matching OS..");
				      }
				//browser
				switch (p.getProperty("browser").toLowerCase()) {
				    case "chrome":
				    	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				        capabilities.setBrowserName("chrome");
				        break;
				    case "edge":
				    	capabilities.setCapability(EdgeOptions.CAPABILITY, options1);
				        capabilities.setBrowserName("MicrosoftEdge");
				        break;
				    default:
				        System.out.println("No matching browser");
				     }
		       
		        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
				
			}	
		
		 if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//launching browser based on condition - locally
			switch(br.toLowerCase())
			{
			case "chrome": 
				options.addArguments("--disable-blink-features=AutomationControlled");
				driver = new ChromeDriver(options);
				break;
			case "edge":
			options1.addArguments("--disable-blink-features=AutomationControlled");
			driver=new EdgeDriver(options1);
			break;
			default: System.out.println("No matching browser..");
						
			}
		}
		
		
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		return driver;
	}
	
	
	
	@AfterTest(groups= {"smoke","regression"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public static WebDriver getDri() {
		return driver;
	}
	

	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\Testngreport\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	
	
}


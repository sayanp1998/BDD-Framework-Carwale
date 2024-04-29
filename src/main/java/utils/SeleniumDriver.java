package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.select.CombiningEvaluator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class SeleniumDriver {
    //this class going to initialize the driver to all classes
    private static SeleniumDriver seleniumDriver;
    private static WebDriver driver;
    private static WebDriverWait explicitWaitDriver;
    public static Properties config = new Properties(); //browser intialized and wait given, that's why not considered as static
    public static Properties OR = new Properties();

    private FileInputStream fis;

    private SeleniumDriver(){
        //This is a private constructor
        try {
            fis = new FileInputStream("./src/main/resources/properties/OR.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            OR.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(config.getProperty("browser").equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (config.getProperty("browser").equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (config.getProperty("browser").equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize(); //maximize the window
        //Explicit wait
        explicitWaitDriver = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));

    }
    public static WebDriver getDriver(){
        return driver;
    }

    public static void setUPDriver(){
        if(seleniumDriver==null){
            seleniumDriver = new SeleniumDriver(); //create Object of SeleniumDriver class
            //When ever we want to call the web driver using this method
            //All the driver initializing code, timeout outs written inside "private Constructor"
            //this method call under before hook
        }
    }

    public static void openPage(String url){
        driver.get(url);
    }

    public static void quitBrowser(){
        if(driver!=null){ //When the driver is running then quit the browser
            driver.close();
            driver.quit();
        }
        seleniumDriver = null; //finally driver=null
        //this method call under afterhook
    }
}

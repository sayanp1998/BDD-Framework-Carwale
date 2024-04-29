package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.SeleniumDriver;

public class Hooks {
    public WebDriver driver;

    @Before
    public void setUp(){
        SeleniumDriver.setUPDriver();
    }

    @After
    public void tearDown(Scenario scenario){
        //Once Failure, Capture the screenshot
        if(scenario.isFailed()){
            SeleniumDriver.getDriver();
            TakesScreenshot ts = (TakesScreenshot)driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
            //whatever method is responsible to take us to the next page is also responsible for the creating object of that page
        }
        SeleniumDriver.quitBrowser();
    }
}

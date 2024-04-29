package page.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.SeleniumDriver;

public class BasePage {
    //Super class contain common driver referance which will be shared in all child classes
    public static WebDriver driver;
    public static carBase carbase; //object of carBase class
    private WebElement mouseOverElement; //limited to this class only

    //Constructor
    public BasePage()
    {
       driver = SeleniumDriver.getDriver();
       carbase = new carBase();
    }
    public void mouserOver(String locator){

        if(locator.endsWith("_XPATH")){
           mouseOverElement = driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)));
        } else if (locator.endsWith("_ID")) {
            mouseOverElement = driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator)));
        } else if (locator.endsWith("_CSS")) {
           mouseOverElement = driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator)));
        } else if (locator.endsWith("_LINK")) {
            mouseOverElement = driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator)));
        } else if (locator.endsWith("_CLASS")) {
            mouseOverElement = driver.findElement(By.className(SeleniumDriver.OR.getProperty(locator)));
        }

        new Actions(driver).moveToElement(mouseOverElement).perform();
    }

    public void click(String locator){
        if(locator.endsWith("_XPATH")){
            driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).click();
        } else if (locator.endsWith("_ID")) {
            driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator))).click();
        } else if (locator.endsWith("_CSS")) {
            driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator))).click();
        } else if (locator.endsWith("_LINK")) {
            driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator))).click();
        } else if (locator.endsWith("_CLASS")) {
            driver.findElement(By.className(SeleniumDriver.OR.getProperty(locator))).click();
        }

    }

    public boolean isElementPresent(String locator){

        try {

            if (locator.endsWith("_XPATH")) {
                driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator)));
            } else if (locator.endsWith("_ID")) {
                driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator)));
            } else if (locator.endsWith("_CSS")) {
                driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator)));
            } else if (locator.endsWith("_LINK")) {
                driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator)));
            } else if (locator.endsWith("_CLASS")) {
                driver.findElement(By.className(SeleniumDriver.OR.getProperty(locator)));
            }
            return true;
        }catch (Throwable t){
            return false;
        }

    }

    public void type(String locator, String value){
        if(locator.endsWith("_XPATH")){
            driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).sendKeys(value);
        } else if (locator.endsWith("_ID")) {
            driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator))).sendKeys(value);
        } else if (locator.endsWith("_CSS")) {
            driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator))).sendKeys(value);
        } else if (locator.endsWith("_LINK")) {
            driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator))).sendKeys(value);
        } else if (locator.endsWith("_CLASS")) {
            driver.findElement(By.className(SeleniumDriver.OR.getProperty(locator))).sendKeys(value);
        }

    }

    public static String getText(String locator){

        if(locator.endsWith("_XPATH")){
            locator = driver.findElement(By.xpath(SeleniumDriver.OR.getProperty(locator))).getText();
        } else if (locator.endsWith("_ID")) {
            locator = driver.findElement(By.id(SeleniumDriver.OR.getProperty(locator))).getText();
        } else if (locator.endsWith("_CSS")) {
            locator = driver.findElement(By.cssSelector(SeleniumDriver.OR.getProperty(locator))).getText();
        } else if (locator.endsWith("_LINK")) {
            locator = driver.findElement(By.linkText(SeleniumDriver.OR.getProperty(locator))).getText();
        } else if (locator.endsWith("_CLASS")) {
            locator = driver.findElement(By.className(SeleniumDriver.OR.getProperty(locator))).getText();
        }
        return locator;
    }



}

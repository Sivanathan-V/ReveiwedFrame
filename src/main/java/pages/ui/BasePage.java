package pages.ui;

import engine.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public abstract class BasePage {
    private final WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.driver.get();
        PageFactory.initElements(this.driver, this);
    }

    public WebDriver getDriver(){
        return DriverManager.driver.get();
    }


    public void navigateToUrl(String url) {
        getDriver().get(url);
    }

    public static Properties getPropertyFile() {
        Properties properties = null;
        try {
            properties = new Properties();
            properties.load(new FileInputStream("./src/main/resources/properties/UIConfig.properties"));
        } catch (Exception e) {
            System.err.println("Unable to read the propertyFile: " + e.getMessage());
        }

        return properties;

    }

    public static String getPropertyFileValue(Properties properties, String key) {

        return (String) properties.get(key);


    }

    public static String getAttribute(WebElement element, String attributeName) {
        try {
            return element.getAttribute(attributeName);
        } catch (Exception e) {
            System.err.println("Error getting element Attribute" + e.getMessage());
            return null;
        }
    }

    public void elementVisibility(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.err.println("Error occured while webdriver wait for element" + e.getMessage());
        }
    }

    public void click(WebElement ele) {
        elementVisibility(ele);
        ele.click();
        //  log.info("Element clicked " + ele);
    }

    public void sendKeys(WebElement ele, String value) {
        elementVisibility(ele);
        ele.sendKeys(value);
        //log.info("value entered" + value);
    }

}

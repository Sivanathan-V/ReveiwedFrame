package engine;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverManager extends ProjectBase {

    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public void launchBrowser() {
        WebDriver driver;
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        DriverManager.driver.set(driver);
        this.setDriver(driver);
    }


}


package engine;

import org.openqa.selenium.WebDriver;

public abstract class ProjectBase {

    public WebDriver getDriver(){
        return DriverManager.driver.get();
    }

}

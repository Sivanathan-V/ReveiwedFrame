package steps.mobile;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.mobile.Mobile_BasePage;


import java.io.IOException;
import java.util.Properties;


public class HooksClass extends Mobile_BasePage {


    static Scenario sc;
    public static Properties properties;

    @Before
    public void beforeScenario(Scenario scenario) {
        properties = getPropertyFile();
        sc = scenario;
    }

    @After
    public void afterScenario(Scenario s) throws IOException {

        s.attach(takesScreenshot(), "images/png", s.getName() + getTimeStamp());


    }


}

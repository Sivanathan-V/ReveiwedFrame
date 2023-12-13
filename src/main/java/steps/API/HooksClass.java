package steps.API;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import pages.API.API_BasePage;

public class HooksClass extends API_BasePage {


    /**
     * @author Sivanathan
     * @see this method is used to set the baseuri
     * @param sc is the parameter passed which should be Scenario type
     * @since 24/08/2023
     */
    @Before
    public static void setup(Scenario sc) {
        try {
            if((sc.getSourceTagNames().contains("@api"))) {
                RestAssured.baseURI= getPropertyFileValue("baseuri");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @author Sivanathan
     * @see this method is used to get the response as String for each scenario
     * @param sc is the parameter passed which should be Scenario type
     * @since 28/08/2023
     */
    @After
    public void afterScenario(Scenario sc) {
        try {
            if((sc.getSourceTagNames().contains("@api"))) {
                sc.log(getResBodyAsPrettyString(response));			}
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }


}

package steps.API;



import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.API.API_BasePage;


public class CommonSteps extends API_BasePage {


    /**
     * @author Sivanathan
     * @see this method is used to verify the status code
     * @param expStatusCode should be passed as an int , it holds the expected statuscode value
     * @since 30/08/2023
     */
    @Then("Verify the status code is {int}")
    public void verify_the_status_code_is(int expStatusCode) {

            int actstatusCode = TC1_ApiStep.pom.getGlobalDatas().getStatusCode();
            Assert.assertEquals("Verify Status Code", expStatusCode,actstatusCode);

    }

}

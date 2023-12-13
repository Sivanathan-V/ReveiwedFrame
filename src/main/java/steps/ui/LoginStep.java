package steps.ui;

import engine.ProjectBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ui.LoginPage;

public class LoginStep extends ProjectBase {

    @Given("User is on the Cyclos LoginPage")
    public void userIsOnTheCyclosLoginPage() {
        new LoginPage().loginPage();
    }

    @When("User should login {string} and {string}")
    public void userShouldLoginAnd(String username, String password) {
        new LoginPage().userName(username).passWord(password).login();
    }

    @Then("User should verify after Login success message {string}")
    public void userShouldVerifyAfterLoginSuccessMessage(String value) {
        Assert.assertEquals(new LoginPage().getDetails(), value);
    }

}

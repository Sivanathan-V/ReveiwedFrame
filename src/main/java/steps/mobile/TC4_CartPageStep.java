package steps.mobile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.mobile.Mobile_BasePage;
import pages.mobile.pageobjectmanager.PageObjectManager;


import java.io.IOException;

public class TC4_CartPageStep extends Mobile_BasePage {



    PageObjectManager pom = new PageObjectManager();

    @Given("User should be on Cart")
    public void userShouldBeOnCart() throws IOException {
        localScreenshot(HooksClass.sc.getName());
        HooksClass.sc.attach(takesScreenshot(), "images/png", HooksClass.sc.getName()+getTimeStamp());

    }

    @When("User should Verify the product added in the cart")
    public void userShouldVerifyTheProductAddedInTheCart() {
        String text = getText(pom.getCartPage().getTxtCartProductName());
        System.out.println(text);

    }

    @When("User should click on delete")
    public void userShouldClickOnDelete() {
        click(pom.getCartPage().getBtnDelete());
    }

    @Then("User should Verify after removing the product from the product success message {string}")
    public void userShouldVerifyAfterRemovingTheProductFromTheProductSuccessMessage(String expMessage) {
        String actMessage = getText(pom.getCartPage().getTxtRemoved());
        Assert.assertEquals("Verify after removed the product", expMessage, actMessage);
        HooksClass.sc.log("Verify after removed the product" + ", " + "Expected Message: " + expMessage + ", "
                + "Actual Message: " + actMessage);
    }


}

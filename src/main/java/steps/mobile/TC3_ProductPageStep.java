package steps.mobile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.mobile.Mobile_BasePage;
import pages.mobile.pageobjectmanager.PageObjectManager;

import java.io.IOException;

public class TC3_ProductPageStep extends Mobile_BasePage {

    PageObjectManager pom = new PageObjectManager();

    @Given("User should be on Product Page")
    public void userShouldBeOnProductPage() throws IOException {
        localScreenshot(HooksClass.sc.getName());
        HooksClass.sc.attach(takesScreenshot(), "images/png", HooksClass.sc.getName()+getTimeStamp());
        // String txtProduct = getText(pom.getProductPage().getProductTitle());

    }

    @When("User should Scroll until the add to cart is visible")
    public void userShouldScrollUntilTheAddToCartIsVisible() throws InterruptedException {
        pom.getProductPage().scrollDownUntilElementFound();

    }

    @When("User should click on add to cart")
    public void userShouldClickOnAddToCart() {
        click(pom.getProductPage().getBtnAddToCart());
        click(pom.getProductPage().getBtnDone());

    }

    @Then("User should verify after adding product in to cart success message {string}")
    public void userShouldVerifyAfterAddingProductInToCartSuccessMessage(String expMessage) {
        click(pom.getCartPage().getBtnCart());
        String actMessage = getText(pom.getCartPage().getTxtCustomessage());
        System.out.println(actMessage);
        Assert.assertEquals("Verify after adding product to the cart", expMessage, actMessage);
        HooksClass.sc.log("Verify after adding product to the cart" + ", " + "Expected Message: " + expMessage + ", "
                + "Actual Message: " + actMessage);
    }


}

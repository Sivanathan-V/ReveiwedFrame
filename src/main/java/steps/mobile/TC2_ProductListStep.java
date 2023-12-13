package steps.mobile;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.mobile.Mobile_BasePage;
import pages.mobile.pageobjectmanager.PageObjectManager;

public class TC2_ProductListStep extends Mobile_BasePage {


    PageObjectManager pom = new PageObjectManager();

    @Given("User should be on Products Page")
    public void userShouldBeOnProductsPage(){
        localScreenshot(HooksClass.sc.getName());
        HooksClass.sc.attach(takesScreenshot(), "images/png", HooksClass.sc.getName()+getTimeStamp());
    }

    @When("User should Scroll")
    public void userShouldScroll() throws InterruptedException {

        pom.getProductList().scroll();
    }

    @When("User should click on product")
    public void userShouldClickOnProduct() {
        pom.getProductList().selectProduct();

    }


    @Then("User should verify after selecting Product success message {string}")
    public void userShouldVerifyAfterSelectingProductSuccessMessage(String expMessage) {
        String actMessage = getText(pom.getProductPage().getTxtProductPage());
        Assert.assertEquals("Verify Product Page Success Message",expMessage,actMessage);
        HooksClass.sc.log("Verify Product Page Success Message"+", "+"Expected Message: "+expMessage+", "+"Actual Message: "+actMessage );

    }





}

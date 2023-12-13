package pages.mobile;


import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Data
public class ProductPage extends Mobile_BasePage {

    public ProductPage() {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }



    By by = MobileBy.xpath("//android.widget.Button[@text='Add to Cart  ']");
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Add to Cart  ']")
    private WebElement btnAddToCart;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='DONE']")
    private WebElement btnDone;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='title']")
    private WebElement productTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'₹') and @index=0]")
    private WebElement txtProductPrice;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Visit the Apple Store']")
    private WebElement txtProductPage;


    public void scrollDownUntilElementFound(){

        scrollDownUntilElementFound(by);
    }


}

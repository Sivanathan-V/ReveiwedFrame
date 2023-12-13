package pages.mobile;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Data
public class CartPage extends Mobile_BasePage {

    public CartPage() {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=' Cart ']")
    private WebElement btnCart;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Delete']")
    private WebElement btnDelete;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Apple')]")
    private WebElement txtCartProductName;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Send as a gift. Include custom message']")
    private WebElement txtCustomessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='was removed from Shopping Cart.']")
    private WebElement txtRemoved;


    public void removeProduct() {
        click(getBtnCart());
        click(getBtnDelete());
    }


}

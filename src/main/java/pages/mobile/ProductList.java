package pages.mobile;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
@Data
public class ProductList extends Mobile_BasePage {

    public ProductList() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Apple')]")
    private List<WebElement> iphoneList;

    @AndroidFindBy(xpath = "//android.widget.ToggleButton[@text='Filters']")
    private WebElement btnFilter;



    public void scroll(){
        desiredScrollSequence(1);
    }

    public void selectProduct() {

        WebElement prod = getIphoneList().get(1);
        click(prod);
    }


}

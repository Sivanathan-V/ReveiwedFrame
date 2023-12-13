package pages.ui;

import engine.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[@id='login-link']")
    protected WebElement btnLoginLink;
    @FindBy(xpath = "//input[@type='text']")
    protected WebElement txtUserName;
    @FindBy(xpath = "//input[@type='password']")
    protected WebElement txtPassword;
    @FindBy(xpath = "//span[text()='Submit']")
    protected WebElement btnLogin;
    @FindBy(xpath = "//div[text()='  Demo user ']")
    protected WebElement txtUserVerification;

    public void loginPage() {
        new DriverManager().launchBrowser();
        navigateToUrl("https://demo.cyclos.org/ui/home");

        //click(getBtnLoginLink());
        getDriver().findElement(By.xpath("//a[@id='login-link']")).click();

    }

    public LoginPage userName(String value) {
        sendKeys(txtUserName, value);
        return this;
    }

    public LoginPage passWord(String value) {
        sendKeys(txtPassword, value);
        return this;
    }

    public void login() {
        click(btnLogin);
    }

    public String getDetails() {
        return txtUserVerification.getText();
    }

}

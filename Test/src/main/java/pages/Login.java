package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends Base {



    @FindBy(xpath = "//input[@id='loginusername']")
    private WebElement inputUserName;

    @FindBy(xpath = "//input[@id='loginpassword']")
    private WebElement InputPassword;

    @FindBy(xpath = "//button[contains(@onclick, 'logIn()')]")
    private WebElement LoginButton;

    @FindBy(xpath = "//h5[@id='logInModalLabel']")
    private WebElement LoginTitle;

    public Login() {
        super();
    }

    @Step("Verify if Login window is opened")
    public boolean IsLoginOpened() {
        return isExpectedElementVisible(LoginTitle);
    }



    @Step("Verify warning message")
    public void clickOnLoginButton() {
        pause(5000);
        SignUpButton.click();
    }


    @Step("Fill all fields to Login")
    public void fillAllTheFieldsToLogin(String xUsername, String xPassword) {
        pause(5000);
        inputUserName.sendKeys(xUsername);
        InputPassword.sendKeys(xPassword);
        LoginButton.click();
    }




}

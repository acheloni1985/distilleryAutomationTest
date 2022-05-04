package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Base64;

public class SignUp extends Base {

    @FindBy(xpath = "//input[@id='sign-username']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@id='sign-password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[contains(@onclick, 'register()')]")
    private WebElement SignUpButton;

    @FindBy(xpath = "//h5[@id='signInModalLabel']")
    private WebElement SignUpTitle;

    public SignUp() {
        super();
    }

    @Step("Verify if Sign Up window is opened")
    public boolean IsSignUpOpened() {
        return isExpectedElementVisible(SignUpTitle);
    }


    @Step("Verify warning message")
    public void clickOnSighUpButton() {
        pause(5000);
        SignUpButton.click();
    }

    @Step("Fill all fields to complete the Sign Up process")
    public void fillSignUpForm(String xUsername, String xPassword) {
        pause(5000);
        inputUsername.sendKeys(xUsername);
        inputPassword.sendKeys(xPassword);
        SignUpButton.click();
    }
}

package pages;

public class HomePage extends Base {

    @FindBy(xpath = "//a[@id='signin2']")
    private WebElement SignUpLink;

    @FindBy(xpath = "//a[@id='login2']")
    private WebElement LoginLink;

    @FindBy(xpath = "//a[contains(@onclick, 'showcart()')]")
    private WebElement CartLink;

    @FindBy(xpath = " //a[@id='nava']")
    private WebElement ProductStoreLogo;



    public HomePage() {
        super();
    }

    @Step("Open SignUp form")
    public void clickOnSignUpLink() {
        pause(5000);
        SignUpLink.click();

    }

    @Step("Open Login form")
    public void clickOnLoginLink() {
        pause(5000);
        LoginLink.click();
    }

    @Step("Open Place Order form")
    public void clickOnCartLink() {
        pause(5000);
        CartLink.click();
    }

    @Step("Open Product Store Page")
    public void clickOnProductStoreLogo() {
        pause(5000);
        ProductStoreLogo.click();
    }

    public static HomePage InitUsing() {
        return new HomePage();
    }

    public void launch() throws InterruptedException {
        get(ConfigProperties.getString(ConfigProperties.envProps, EnvtProperties.URL.name()), loginBtn);
    }
}

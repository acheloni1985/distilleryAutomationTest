package pages;

public class ProductStore extends Base {

    @FindBy(xpath = "//a[@id='cat']")
    private WebElement CategoriesLabel;

    @FindBy(xpath = "//button[@id='next2']")
    private WebElement NextButton;

    @FindBy(xpath = "//button[@id='prev2']")
    private WebElement PrevButton;

    @FindBy(xpath = "//a[@href='prod.html?idp_=1']")
    private WebElement Product1;

    @FindBy(xpath = "//a[@href='prod.html?idp_=13']")
    private WebElement Product2;

    @FindBy(xpath = "//a[@href='prod.html?idp_=12']")
    private WebElement Product3;

    @FindBy(xpath = "//a[@class='btn btn-success btn-lg']")
    private WebElement AddToCartButton;

    @FindBy(xpath = "//h2[@class='name']")
    private WebElement TitleProduct;



    public ProductStore() {
        super();
    }

    @Step("Verify if Place Order page is opened")
    public boolean IsPlaceOrderOpened() {
        return isExpectedElementVisible(CategoriesLabel);
    }

    @Step("Verify if Title Product is visible")
    public boolean IsTitleProductDisplayed() {
        return isExpectedElementVisible(TitleProduct);
    }

    @Step("Verify warning message")
    public void clickOnProduct1() {
        pause(5000);
        Product1.click();
    }

    @Step("Verify warning message")
    public void clickOnProduct2() {
        pause(5000);
        Product2.click();
    }

    @Step("Verify warning message")
    public void clickOnProduct3() {
        pause(5000);
        Product3.click();
    }

    @Step("Verify warning message")
    public void clickOnAddToCartButton() {
        pause(5000);
        AddToCartButton.click();
    }

    @Step("Verify warning message")
    public void clickOnNextButton() {
        pause(5000);
        NextButton.click();
    }

    @Step("Verify warning message")
    public void clickOnPrevButton() {
        pause(5000);
        PrevButton.click();
    }



}

package pages;


public class PlaceOrder extends Base {

    @FindBy(xpath = "//input[@id='name']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@id='country']")
    private WebElement inputCountry;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement inputCity;

    @FindBy(xpath = "//input[@id='card']")
    private WebElement inputCreditCard;

    @FindBy(xpath = "//input[@id='month']")
    private WebElement inputMonth;

    @FindBy(xpath = "//input[@id='year']")
    private WebElement inputYear;

    @FindBy(xpath = "//button[contains(@onclick, 'purchaseOrder()')]")
    private WebElement purchaseButton;

    @FindBy(xpath = "//h5[@id='orderModalLabel']")
    private WebElement placeOrderTitle;

    @FindBy(xpath = "//button[@class = 'btn btn-success']")
    private WebElement placerOrderButton;


    public PlaceOrder() {
        super();
    }

    @Step("Verify if Place Order page is opened")
    public boolean IsPlaceOrderOpened() {
        return isExpectedElementVisible(placeOrderTitle);
    }

    @Step("Fill all fields to complete the place order process")
    public void fillSignUpForm(String xName, String xCountry, String xCity, String xCard, String xMonth, String xYear) {
        pause(5000);
        inputName.sendKeys(xName);
        inputCountry.sendKeys(xCountry);
        inputCity.sendKeys(xCity);
        inputCreditCard.sendKeys(xCard);
        inputMonth.sendKeys(xMonth);
        inputYear.sendKeys(xYear);
        purchaseButton.click();
    }

    public void clickOnPlaceOrderButton() {
        pause(5000);
        placerOrderButton.click();
    }


}

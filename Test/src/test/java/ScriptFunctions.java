import org.ehoffman.testng.extensions.Fixture;
import org.junit.jupiter.api.Test;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.asserts.SoftAssert;
import com.sforce.cd.kumonium.extensions.testng.SalesforceEnforcer;
import com.sforce.cd.kumonium.extensions.webdriver.KumoniumWebDriverExtension;
import com.sforce.pc.test.baseclasses.BaseTestCase;
import pages.*;


public class ScriptFunctions extends BaseTestCase {

    @Test
    public void SignUpNewUser () throws InterruptedException {
        try{
            SoftAssert softAssert = new SoftAssert();
            HomePage homePage = HomePage.InitUsing();
            homePage.launch();

            SignUp SignUp;
            SignUp = HomePage.clickOnSignUpLink();
            SignUp.fillSignUpForm("Alejandro","12345");

            softAssert.assertFalse(SignUp.IsSignUpOpened(), "Expected SignUp form is displayed");
            softAssert.assertAll();

        } catch (AssertionError | Exception e) {
            if (BasePage.getDriver() != null)
                takesScreenShot();
            throw e;
        }
    }

    @Test
    public void LoginUser () throws InterruptedException {
        try{
            SoftAssert softAssert = new SoftAssert();
            HomePage homePage = HomePage.InitUsing();
            homePage.launch();

            Login Login;
            Login = HomePage.clickOnLoginLink();
            Login.fillAllTheFieldsToLogin("Alejandro","12345");

            softAssert.assertFalse(Login.IsLoginOpened(), "Expected Login form is displayed");
            softAssert.assertAll();

        } catch (AssertionError | Exception e) {
            if (BasePage.getDriver() != null)
                takesScreenShot();
            throw e;
        }
    }

    @Test
    public void CartSectionPurchaseOrder  () throws InterruptedException {
        try{
            SoftAssert softAssert = new SoftAssert();
            HomePage homePage = HomePage.InitUsing();
            homePage.launch();

            PlaceOrder PlaceOrder;
            PlaceOrder = HomePage.clickOnCartLink();
            PlaceOrder.fillSignUpForm("Alejandro","Uruguay","Mercedes","212123233","12","2022");

            softAssert.assertFalse(PlaceOrder.IsPlaceOrderOpened(), "Expected Place Order form is displayed");
            softAssert.assertAll();

        } catch (AssertionError | Exception e) {
            if (BasePage.getDriver() != null)
                takesScreenShot();
            throw e;
        }
    }

    @Test
    public void ProductStorePage  () throws InterruptedException {
        try{
            SoftAssert softAssert = new SoftAssert();
            HomePage homePage = HomePage.InitUsing();
            homePage.launch();

            ProductStore ProductStore;
            ProductStore = HomePage.clickOnProductStoreLogo();
            ProductStore.clickOnProduct1();
            ProductStore.clickOnAddToCartButton();
            softAssert.assertFalse(ProductStore.IsTitleProductDisplayed(), "Expected Title Product is displayed");

            HomePage.clickOnProductStoreLogo();
            ProductStore.clickOnNextButton();
            ProductStore.clickOnProduct2();
            ProductStore.clickOnAddToCartButton();
            softAssert.assertFalse(ProductStore.IsTitleProductDisplayed(), "Expected Title Product is displayed");

            HomePage.clickOnProductStoreLogo();
            ProductStore.clickOnNextButton();
            ProductStore.clickOnProduct3();
            ProductStore.clickOnAddToCartButton();
            softAssert.assertFalse(ProductStore.IsTitleProductDisplayed(), "Expected Title Product is displayed");

            softAssert.assertAll();

        } catch (AssertionError | Exception e) {
            if (BasePage.getDriver() != null)
                takesScreenShot();
            throw e;
        }
    }






}

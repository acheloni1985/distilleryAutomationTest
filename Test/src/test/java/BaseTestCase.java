import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.ehoffman.testng.extensions.Fixture;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.sforce.cd.kumonium.extensions.webdriver.KumoniumWebDriverExtension;
import com.sforce.pc.util.BasePage;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import java.lang.reflect.Method;

public class BaseTestCase {

    public final static Logger logger = Logger.getLogger(BaseTestCase.class);


    public static int testCaseNumber = 1;

    /**
     * "before" is kind of redundant for now since we cannot pass and obtain the
     * testmethod name here and elsewhere (other than pass it to a system property
     * through the System.set/getProperty - it's a threadsafe but requires us to
     * specify implicitly the name of every testcase)
     * @throws InterruptedException
     */

    @BeforeMethod(alwaysRun = true)
    @Fixture(factory={KumoniumWebDriverExtension.DESIRED_CAPABILITIES.class})
    public void doBeforeMethod(Method method) throws InterruptedException {
        String fullClassName = this.getClass().getName();
        Integer index = fullClassName.lastIndexOf('.');
        String className = index == -1 ? this.getClass().getName() : fullClassName.substring(index + 1);
        /*
         * logger.debug("*** Test Class: " + className + ".class");
         * logger.debug("*** Running (thread #" + Thread.currentThread().getId() + "): "
         * + method.getName());
         */
        System.setProperty("jobName", className + "#" + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void doAfterMethod(ITestResult result, Method method) {
        BasePage.clear();
        int status = result.getStatus();
        switch (status) {
            case ITestResult.SUCCESS:
                System.out.println();
                logger.debug("TestCase# " + (testCaseNumber++) + ": PASSED. TestName: " + method.getName() + ", ClassName: " + this.getClass().getName());
                System.out.println();
                break;
            case ITestResult.FAILURE:
                System.out.println();
                logger.debug("TestCase# " + (testCaseNumber++) + ": FAILED. TestName: " + method.getName() + ", ClassName: " + this.getClass().getName());
                System.out.println();
                break;
            case ITestResult.SKIP:
                System.out.println();
                logger.debug("TestCase# " + (testCaseNumber++) + ": SKIPPED FOR NOW - WILL RETRY AGAIN. TestName: " + method.getName() + ", ClassName: " + this.getClass().getName());
                System.out.println();
                break;
            case ITestResult.SUCCESS_PERCENTAGE_FAILURE:
                System.out.println();
                logger.debug("TestCase# " + (testCaseNumber++) + ": SKIPPED - SKIPPED FOR NOW - RESULT IS STILL UNKNOWN . TestName: " + method.getName() + ", ClassName: " + this.getClass().getName());
                System.out.println();
                break;
            default:
                throw new RuntimeException("Invalid status");
        }

    }

    public static void logger(String logDescription) {
        //logger.info(logDescription);
        Allure.step(logDescription);
    }

    public static byte[] takesScreenShot() {
        return ((TakesScreenshot)BasePage.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}

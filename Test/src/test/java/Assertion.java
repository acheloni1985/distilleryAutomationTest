import java.util.Collection;
import java.util.Map;
import java.util.Set;


public class Assertion implements IAssertLifecycle  {
    protected void doAssert(IAssert assertCommand) {
        onBeforeAssert(assertCommand);
        try {
            executeAssert(assertCommand);
            onAssertSuccess(assertCommand);
        } catch(AssertionError ex) {
            onAssertFailure(assertCommand, ex);
            throw ex;
        } finally {
            onAfterAssert(assertCommand);
        }
    }

    public void assertFalse(final boolean condition, final String message) {
        doAssert(new SimpleAssert(message) {
            @Override
            public void doAssert() {
                org.testng.Assert.assertFalse(condition, message);
            }

            @Override
            public Object getActual() {
                return condition;
            }

            @Override
            public Object getExpected() {
                return false;
            }
        });
    }
}

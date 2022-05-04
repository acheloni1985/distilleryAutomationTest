import java.util.Map;
import org.testng.collections.Maps;

public class SoftAssert extends Assertion {
    // LinkedHashMap to preserve the order
    private Map<AssertionError, IAssert> m_errors = Maps.newLinkedHashMap();

    @Override
    public void executeAssert(IAssert a) {
        try {
            a.doAssert();
        } catch(AssertionError ex) {
            onAssertFailure(a, ex);
            m_errors.put(ex, a);
        }
    }

    public void assertAll() {
        if (! m_errors.isEmpty()) {
            StringBuilder sb = new StringBuilder("The following asserts failed:\n");
            boolean first = true;
            for (Map.Entry<AssertionError, IAssert> ae : m_errors.entrySet()) {
                if (first) {
                    first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(ae.getValue().getMessage());
            }
            throw new AssertionError(sb.toString());
        }
    }
}


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Test runner class for the tests in CardGameTest.
 */
public class UnitTestingImpl {

    public static void main(String[] args) {
        Result testResult = JUnitCore.runClasses(CardGameTest.class);

        for (Failure failure : testResult.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("Tests successful: " + testResult.wasSuccessful());
    }
}

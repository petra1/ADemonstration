package ch.ritter1.apps.ademonstration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// 1. Annotate the class with RunWith(Suite.class)
@RunWith(Suite.class)

// 2. Specify the classes to be included in this suite
@Suite.SuiteClasses({
        AccessibilityTest.class,
        NotAccessibleTest.class,
        HtmlStructureTest.class
        // Add more test classes here if needed
})

/**
 * A test suite that bundles all accessibility-related tests in this project.
 * When you run this class, all test classes listed here will be executed
 * sequentially.
 * The class itself must remain empty.
 */
public class AllAccessibilityTests {
    // This class body is intentionally left empty.
}

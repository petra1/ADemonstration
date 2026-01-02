package ch.ritter1.apps.ademonstration;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerActions.open;
import static androidx.test.espresso.contrib.NavigationViewActions.navigateTo;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

import android.view.View;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented tests to verify that elements that are intentionally
 * not accessible (e.g., decorative images) are correctly implemented.
 */
@RunWith(AndroidJUnit4.class)
public class NotAccessibleTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testHomeFragment_NotAccessible() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_home)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_home));

        // TODO: Implement "not accessible" tests for HomeFragment
    }

    @Test
    public void testGraphicFragment_NotAccessible() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_graphics)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_graphics));

        // --- Assertions for NotAccessibleTest ---

        // Verify that imageView1, which is missing the attribute, has a null contentDescription.
        onView(withId(R.id.imageView1)).check(matches(ViewMatchers.withContentDescription(nullValue(String.class))));

        // Verify that imageView2, which has contentDescription="@null", is also treated as having a null contentDescription.
        onView(withId(R.id.imageView2)).check(matches(ViewMatchers.withContentDescription(nullValue(String.class))));
    }


    @Test
    public void testImageButtonFragment_NotAccessible() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_image_button)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_image_button));

        // TODO: Implement "not accessible" tests for ImageButtonFragment
    }

    @Test
    public void testHeadingsFragment_NotAccessible() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_headings)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_headings));

        // TODO: Implement "not accessible" tests for HeadingsFragment
    }

    @Test
    public void testEditFragment_NotAccessible() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_edit)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_edit));

        // --- Assertions for NotAccessibleTest ---

        // Verify that text_First_name does NOT have a labelFor attribute pointing to the EditText.
        onView(withId(R.id.text_First_name)).check(matches(not(hasLabelFor(R.id.editText_Fist_name))));

        // Verify that the EditText for the first name does NOT have a hint attribute.
        onView(withId(R.id.editText_Fist_name)).check(matches(withHint(nullValue(String.class))));
    }

    @Test
    public void testCheckboxesFragment_NotAccessible() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_checkboxes)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_checkboxes));

        // TODO: Implement "not accessible" tests for CheckboxesFragment
    }

    @Test
    public void testContrastFragment_NotAccessible() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_contrast)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_contrast));

        // TODO: Implement "not accessible" tests for ContrastFragment
    }

    @Test
    public void testTabFragment_NotAccessible() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_tab)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_tab));

        // TODO: Implement "not accessible" tests for TabFragment
    }

    @Test
    public void testFocusVisibleFragment_NotAccessible() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_focus_visible)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_focus_visible));

        // TODO: Implement "not accessible" tests for FocusVisibleFragment
    }

    @Test
    public void testContactFragment_NotAccessible() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_contact)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_contact));

        // TODO: Implement "not accessible" tests for ContactFragment
    }

    @Test
    public void testUsageFragment_NotAccessible() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_usage)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_usage));

        // TODO: Implement "not accessible" tests for UsageFragment
    }

    @Test
    public void testAboutFragment_NotAccessible() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_about)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_about));

        // TODO: Implement "not accessible" tests for AboutFragment
    }

    // --- Helper Methods ---

    /**
     * Custom Matcher to check if a View (typically a TextView) has a 'labelFor' property
     * pointing to a specific View ID. This is crucial for WCAG 3.3.2 (Labels or Instructions).
     * @param expectedId The resource ID of the View that this View should be a label for.
     * @return A Matcher for the View.
     */
    public static Matcher<View> hasLabelFor(final int expectedId) {
        return new BoundedMatcher<View, View>(View.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has labelFor property with id: " + expectedId);
            }

            @Override
            protected boolean matchesSafely(View item) {
                // In Espresso, if labelFor is not set, getLabelFor() returns -1 (View.NO_ID)
                return item.getLabelFor() == expectedId;
            }
        };
    }
}

package ch.ritter1.apps.ademonstration;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerActions.open;
import static androidx.test.espresso.contrib.NavigationViewActions.navigateTo;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AccessibilityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    // WCAG 2.2, Success Criterion 1.1.1 Non-text Conten
    @Test
    public void testGraphicHasContentDescription() {
        // Step 1: Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());
        // Step 2: Navigate to the menu item ‘Alternative Texts’ (nav_graphics)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_graphics));
        // Step 3: Check whether the images have content descriptions.
        onView(withId(R.id.imageView3)).check(matches(withContentDescription(not(isEmptyOrNullString()))));
    }

    // WCAG 2.2, Success Criterion 1.3.1 Info and Relationships (Headings)
    @Test
    public void testTextViewIsHeading() {
        // Step 1: Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());
        // Step 2: Navigate to the menu item ‘Alternative Texts’ (nav_graphics)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_graphics));
        // Step 3: Check whether the TextViews are marked as accessibility headings.
        onView(withId(R.id.textView1)).check(matches(isAccessibilityHeading()));
        onView(withId(R.id.textView3)).check(matches(isAccessibilityHeading()));
        onView(withId(R.id.textView5)).check(matches(isAccessibilityHeading()));
    }

    /**
     * A custom matcher that checks whether a view is marked as an
     * accessibility heading (view.isAccessibilityHeading()).
     */
    public static Matcher<View> isAccessibilityHeading() {
        return new BoundedMatcher<View, View>(View.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("is an accessibility heading.");
            }

            @Override
            protected boolean matchesSafely(View view) {
                return view.isAccessibilityHeading();
            }
        };
    }

}

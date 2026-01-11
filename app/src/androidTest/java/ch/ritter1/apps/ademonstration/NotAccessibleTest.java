package ch.ritter1.apps.ademonstration;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerActions.open;
import static androidx.test.espresso.contrib.NavigationViewActions.navigateTo;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.TextView;

import androidx.core.graphics.ColorUtils;
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

        // WCAG 2.2, Success Criterion 1.1.1 Non-text Content
        onView(withId(R.id.imageButton1)).check(matches(ViewMatchers.withContentDescription(nullValue(String.class))));

        // WCAG 2.2, Success Criterion 2.5.8: Target Size (Minimum)
        onView(withId(R.id.imageButton1)).check(matches(not(withMinTargetSize(48, 48))));
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

        // --- Assertions for NotAccessibleTest ---
        // WCAG 2.2, Success Criterion 1.4.3 Contrast (Minimum)
        // Verify that the contrast ratio is below the minimum requirement of 4.5
        onView(withId(R.id.textView4)).check(matches(withContrastRatioLessThan(4.5)));
        onView(withId(R.id.textView6)).check(matches(withContrastRatioLessThan(4.5)));
        onView(withId(R.id.textView8)).check(matches(withContrastRatioLessThan(4.5)));
    }



    @Test
    public void testFocusVisibleFragment_NotAccessible() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_focus_visible)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_focus_visible));

        // Verify that buttons 1, 2, and 3 do not have a StateListDrawable as background
        onView(withId(R.id.bt_1)).check(matches(not(withStateListDrawableBackground())));
        onView(withId(R.id.bt_2)).check(matches(not(withStateListDrawableBackground())));
        onView(withId(R.id.bt_3)).check(matches(not(withStateListDrawableBackground())));
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

    /**
     * Custom Matcher to check if a TextView has a contrast ratio of less than a given value.
     * This is crucial for testing views that fail WCAG 1.4.3 (Contrast (Minimum)).
     * @param expectedRatio The maximum expected contrast ratio.
     * @return A Matcher for the View.
     */
    public static Matcher<View> withContrastRatioLessThan(final double expectedRatio) {
        return new BoundedMatcher<View, TextView>(TextView.class) {
            private String failureDescription;

            @Override
            public void describeTo(Description description) {
                description.appendText("with a contrast ratio of less than " + expectedRatio);
                if (failureDescription != null) {
                    description.appendText("[Actual]: " + failureDescription);
                }
            }

            @Override
            protected boolean matchesSafely(TextView textView) {
                int textColor = textView.getCurrentTextColor();
                Drawable background = textView.getBackground();
                if (background instanceof ColorDrawable) {
                    int backgroundColor = ((ColorDrawable) background).getColor();
                    double contrast = ColorUtils.calculateContrast(textColor, backgroundColor);
                    System.out.println("Actual contrast ratio for view " + textView.getResources().getResourceEntryName(textView.getId()) + " is " + contrast);
                    if (contrast >= expectedRatio) {
                        failureDescription = "contrast ratio is " + contrast;
                        return false;
                    }
                    return true;
                }
                failureDescription = "background is not a solid color";
                return false;
            }
        };
    }

    public static Matcher<View> withMinTargetSize(final int minWidthDp, final int minHeightDp) {
        return new BoundedMatcher<View, View>(View.class) {
            private String failureDescription;

            @Override
            public void describeTo(Description description) {
                description.appendText("with a minimum target size of " + minWidthDp + "dp x " + minHeightDp + "dp");
                if (failureDescription != null) {
                    description.appendText("\n[Actual]: " + failureDescription);
                }
            }

            @Override
            protected boolean matchesSafely(View item) {
                // Convert expected dp to pixels
                final float density = item.getResources().getDisplayMetrics().density;
                final float expectedMinWidthPx = minWidthDp * density;
                final float expectedMinHeightPx = minHeightDp * density;

                // Get actual minWidth and minHeight from the View in pixels
                final int actualMinWidthPx = item.getMinimumWidth();
                final int actualMinHeightPx = item.getMinimumHeight();

                // Check if the actual minimums meet the expected minimums
                boolean matches = actualMinWidthPx >= expectedMinWidthPx && actualMinHeightPx >= expectedMinHeightPx;

                if (!matches) {
                    float actualMinWidthDp = actualMinWidthPx / density;
                    float actualMinHeightDp = actualMinHeightPx / density;
                    failureDescription = "minWidth=" + String.format("%.1f", actualMinWidthDp) + "dp, minHeight=" + String.format("%.1f", actualMinHeightDp) + "dp";
                }

                return matches;
            }
        };
    }

    public static Matcher<View> withStateListDrawableBackground() {
        return new BoundedMatcher<View, View>(View.class) {
            @Override
            protected boolean matchesSafely(View view) {
                return view.getBackground() instanceof StateListDrawable;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with a StateListDrawable background");
            }
        };
    }
}
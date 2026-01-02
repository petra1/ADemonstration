package ch.ritter1.apps.ademonstration;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerActions.open;
import static androidx.test.espresso.contrib.NavigationViewActions.navigateTo;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
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

    @Test
    public void testHomeFragment() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_home)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_home));

        onView(withId(R.id.image_view_logo)).check(matches(withContentDescription(not(isEmptyOrNullString()))));
    }

    @Test
    public void testGraphicFragment() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item ‘Alternative Texts’ (nav_graphics)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_graphics));

        // WCAG 2.2, Success Criterion 1.1.1 Non-text Conten
        // Check whether the images have content descriptions.
        onView(withId(R.id.imageView3)).check(matches(withContentDescription(not(isEmptyOrNullString()))));

        // WCAG 2.2, Success Criterion 1.3.1: Info and Relationships (Heading)
        onView(withId(R.id.textView1)).check(matches(isAccessibilityHeading()));
        onView(withId(R.id.textView3)).check(matches(isAccessibilityHeading()));
        onView(withId(R.id.textView5)).check(matches(isAccessibilityHeading()));
    }


    @Test
    public void testImageButtonFragment() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_image_button)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_image_button));


        // WCAG 2.2, Success Criterion 1.3.1: Info and Relationships (Heading)
        // Check whether the TextViews with the ID 'imageButton_Title' is an accessibility headings
        onView(withId(R.id.imageButton_Title)).check(matches(isAccessibilityHeading()));

        // WCAG 2.2, Success Criterion 1.1.1 Non-text Conten (alternative text for images)
        // Check whether the imagesButton for Question 2 has a content descriptions
        onView(withId(R.id.imageButton2)).check(matches(withContentDescription(not(isEmptyOrNullString()))));

        // WCAG 2.2, Success Criterion 2.5.8: Target Size (Minimum)
        // Check if the button's minimum target size is set to at least 48x48dp
        onView(withId(R.id.imageButton2)).check(matches(withMinTargetSize(48, 48)));

        // WCAG 2.2, SC 4.1.3 Status Messages
        // Check whether the TextView for Question 2 is an accessibility live region
        onView(withId(R.id.imageButton_Question2)).check(matches(isLiveRegion()));

    }

    //The HeadingFrame is HTML-based; the corresponding accessibility tests can be found in the HtmlStructureTest.

    
    @Test
    public void testEditFragment() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_edit)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_edit));

        // WCAG 2.2, Success Criterion 1.3.1: Info and Relationships (Heading)
        onView(withId(R.id.text_Title)).check(matches(isAccessibilityHeading()));

        // WCAG 2.2, Success Criterion 1.3.1: Info and Relationships (Label)
        onView(withId(R.id.text_Last_name)).check(matches(hasLabelFor(R.id.editText_Last_name)));


        //--- Dynamic Content Description Test --
        // NOTE: The Dynamic Content Description Test is intended to be run on physical devices.
        // It is likely to fail on an emulator, possibly due to timing issues.

        // WCAG 2.2, SC 4.1.3 Status Messages
        // PERFORM THE ACTION: Click the "Set First Name" button to trigger the dynamic change.
        onView(withId(R.id.bt_first_name)).perform(click());
        //Checks whether a dynamic contentDescription exists for the button with the ID bt_first_name and whether it is not empty.
        onView(withId(R.id.bt_first_name)).check(matches(withContentDescription(not(isEmptyOrNullString()))));

        // WCAG 2.2, SC 4.1.3 Status Messages
        // PERFORM THE ACTION: Click the "Set Last Name" button to trigger the dynamic change.
        onView(withId(R.id.bt_last_name)).perform(click());
        // Checks whether a dynamic contentDescription exists for the button with the ID bt_last_name and whether it is not empty.
        onView(withId(R.id.bt_last_name)).check(matches(withContentDescription(not(isEmptyOrNullString()))));
    }



    @Test
    public void testCheckboxesFragment() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_checkboxes)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_checkboxes));

        // WCAG 2.2, Success Criterion 1.3.1: Info and Relationships (Label)
        onView(withId(R.id.checkBox3)).check(matches(withContentDescription(not(isEmptyOrNullString()))));
        onView(withId(R.id.checkBox4)).check(matches(withContentDescription(not(isEmptyOrNullString()))));
    }

    @Test
    public void testContrastFragment() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_contrast)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_contrast));

        // WCAG 2.2, Success Criterion 1.4.3 Contrast (Minimum)
        onView(withId(R.id.textView3)).check(matches(withContrastRatio(4.5)));
        onView(withId(R.id.textView5)).check(matches(withContrastRatio(4.5)));
        onView(withId(R.id.textView7)).check(matches(withContrastRatio(4.5)));
    }

    @Test
    public void testTabFragment() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_tab)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_tab));

        // TODO: Implement accessibility tests for TabFragment
    }

    @Test
    public void testFocusVisibleFragment() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_focus_visible)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_focus_visible));

        // TODO: Implement accessibility tests for FocusVisibleFragment
    }

    @Test
    public void testContactFragment() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_contact)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_contact));

        // TODO: Implement accessibility tests for ContactFragment
    }

    //The UsageFrame is HTML-based; the corresponding accessibility tests can be found in the HtmlStructureTest.

    @Test
    public void testAboutFragment() {
        // Open the navigation drawer
        onView(withId(R.id.drawer_layout)).perform(open());

        // Navigate to the menu item (nav_about)
        onView(withId(R.id.nav_view)).perform(navigateTo(R.id.nav_about));

        // TODO: Implement accessibility tests for AboutFragment
    }


    //-- Helper-methods
    /**
     * Custom Matcher to check if a View is marked as an accessibility heading.
     * This is useful for verifying WCAG 1.3.1 (Info and Relationships).
     * @return A Matcher for the View.
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

    /**
     * Custom Matcher to check if a View has a minimum target size (minWidth/minHeight) in dp.
     * This is ideal for verifying WCAG 2.5.8 (Target Size Minimum).
     * @param minWidthDp The expected minimum width in dp.
     * @param minHeightDp The expected minimum height in dp.
     * @return A Matcher for the View.
     */
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

    /**
     * Custom Matcher to check if a View is an accessibility live region.
     * A live region notifies accessibility services of changes.
     * This is useful for verifying WCAG 4.1.3 (Status Messages).
     * @return A Matcher for the View.
     */
    public static Matcher<View> isLiveRegion() {
        return new BoundedMatcher<View, View>(View.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("is an accessibility live region.");
            }

            @Override
            protected boolean matchesSafely(View view) {
                // A view is a live region if the mode is not ACCESSIBILITY_LIVE_REGION_NONE
                return view.getAccessibilityLiveRegion() != View.ACCESSIBILITY_LIVE_REGION_NONE;
            }
        };
    }

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
                return item.getLabelFor() == expectedId;
            }
        };
    }



    /**
     * Custom Matcher to check if a TextView has a contrast ratio of at least a given value.
     * This is crucial for WCAG 1.4.3 (Contrast (Minimum)).
     * @param expectedRatio The minimum expected contrast ratio.
     * @return A Matcher for the View.
     */
    public static Matcher<View> withContrastRatio(final double expectedRatio) {
        return new BoundedMatcher<View, TextView>(TextView.class) {
            private String failureDescription;

            @Override
            public void describeTo(Description description) {
                description.appendText("with a contrast ratio of at least " + expectedRatio);
                if (failureDescription != null) {
                    description.appendText("\n[Actual]: " + failureDescription);
                }
            }

            @Override
            protected boolean matchesSafely(TextView textView) {
                int textColor = textView.getCurrentTextColor();
                Drawable background = textView.getBackground();
                if (background instanceof ColorDrawable) {
                    int backgroundColor = ((ColorDrawable) background).getColor();
                    double contrast = ColorUtils.calculateContrast(textColor, backgroundColor);
                    if (contrast < expectedRatio) {
                        failureDescription = "contrast ratio is " + contrast;
                        return false;
                    }
                    System.out.println("Contrast ratio is " + contrast);
                    return true;
                }
                failureDescription = "background is not a solid color";
                return false;
            }
        };
    }

}
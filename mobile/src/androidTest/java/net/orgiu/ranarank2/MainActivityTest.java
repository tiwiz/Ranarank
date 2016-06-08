package net.orgiu.ranarank2;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.Toolbar;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private final String VALID_NAME = "abcd";
    private final String INVALID_NAME = "abc";

    @Rule
    public final ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void startActivity_FabHidden() throws Exception {
        onView(withId(R.id.btnStartCounter)).check(matches(not(isDisplayed())));
    }

    @Test
    public void insertShortName_FabHidden() throws Exception {
        onView(withId(R.id.txtCompetitionName)).perform(typeText(INVALID_NAME), closeSoftKeyboard());
        onView(withId(R.id.btnStartCounter)).check(matches(not(isDisplayed())));
    }

    @Test
    public void insertLongerName_FabShown() throws Exception {
        onView(withId(R.id.txtCompetitionName)).perform(typeText(VALID_NAME), closeSoftKeyboard());
        onView(withId(R.id.btnStartCounter)).check(matches(isDisplayed()));
    }

    @Test
    public void insertLongName_SavedInStorage() throws Exception {
        onView(withId(R.id.txtCompetitionName)).perform(typeText(VALID_NAME), closeSoftKeyboard());
        onView(withId(R.id.btnStartCounter)).perform(click());

        onView(withId(R.id.chronometerToolbar))
                .check(matches(isDisplayed()))
                .check(matches(isAssignableFrom(Toolbar.class)))
                .check(matches(withTitle(is(VALID_NAME))));
    }

    private static Matcher<Object> withTitle(final Matcher<CharSequence> titleMatcher) {
        return new BoundedMatcher<Object, Toolbar>(Toolbar.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("with toolbar title: ");
                titleMatcher.describeTo(description);
            }

            @Override
            protected boolean matchesSafely(Toolbar toolbar) {
                return titleMatcher.matches(toolbar.getTitle());
            }
        };
    }
}
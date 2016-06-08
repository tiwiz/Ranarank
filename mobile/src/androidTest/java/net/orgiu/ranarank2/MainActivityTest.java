package net.orgiu.ranarank2;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public final ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void startActivity_FabHidden() throws Exception {
        onView(withId(R.id.btnStartCounter)).check(matches(not(isDisplayed())));
    }

    @Test
    public void insertShortName_FabHidden() throws Exception {
        onView(withId(R.id.txtCompetitionName)).perform(typeText("abc"));
        onView(withId(R.id.btnStartCounter)).check(matches(not(isDisplayed())));
    }

    @Test
    public void insertLongerName_FabShown() throws Exception {
        onView(withId(R.id.txtCompetitionName)).perform(typeText("abcd"));
        onView(withId(R.id.btnStartCounter)).check(matches(isDisplayed()));
    }
}
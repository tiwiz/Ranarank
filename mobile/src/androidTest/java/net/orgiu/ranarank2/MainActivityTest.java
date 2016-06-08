package net.orgiu.ranarank2;

import android.support.test.espresso.core.deps.guava.util.concurrent.ExecutionError;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
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

        String actualName = RanaApp.getStorage().getCompetitionName();

        if (!actualName.equals(VALID_NAME)) throw new Exception("ERROR: was expecting \"" + VALID_NAME + "\" but it was \"" + actualName + "\"");
    }
}
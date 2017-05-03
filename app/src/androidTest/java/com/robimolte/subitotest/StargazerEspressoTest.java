package com.robimolte.subitotest;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.robimolte.subitotest.model.Stargazer;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Mockito.mock;


/**
 * Created by robimolte on 04/02/2017.
 */
public class StargazerEspressoTest {

    @Mock
    MainScreenStargazer.View  mView;

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Rule
    // third parameter is set to false which means the activity is not started automatically
    public ActivityTestRule<ResultActivity> rule =
            new ActivityTestRule(ResultActivity.class, true, false);

    @Before
    public void setupNotesPresenter() {
        mView = mock(MainScreenStargazer.View.class);
    }

    @Test
    public void ensureTextChangesWork() {
        onView(withId(R.id.ownerRepo)).perform(typeText("Hello")).check(matches(withText("Hello")));

    }


    @Test
    public void startResultActivity() {
        Intent intent = new Intent();
        List<Stargazer> ll = new ArrayList<Stargazer>();
        Stargazer f = new Stargazer("a","b");
        ll.add(f);
        intent.putExtra("stargazer", (Serializable) ll);
        rule.launchActivity(intent);
        onView(withId(R.id.resultLabel)).check(matches(withText("Results:")));
    }








}

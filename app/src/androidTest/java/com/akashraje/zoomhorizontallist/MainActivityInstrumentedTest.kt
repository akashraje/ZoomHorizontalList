package com.akashraje.zoomhorizontallist

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.UiController
import android.support.test.espresso.ViewAction
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import com.akashraje.zoomhorizontallist.View.GridElementHolder
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by akashraje on 06/12/17.
 */

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @Rule @JvmField
    var mainActivity: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testHorizontalList_Visible() {
        onView(withId(R.id.gridView)).check(matches(isDisplayed()))
    }


    @Test
    fun testHorizontalList_Focusable() {
        onView(withId(R.id.gridView)).check(matches(isFocusable()))
    }

    @Test
    fun  testHorizontalList_OnClickingRightNextViewGetsFocus() { // This should check Scale
        onView(withId(R.id.gridView))
                .perform(RecyclerViewActions.actionOnItemAtPosition<GridElementHolder>(0, InnerViewClickAction()
                .clickChildViewWithId(R.id.btnLeft)))
                .check(matches(hasFocus()))
    }
}

class InnerViewClickAction {

    fun clickChildViewWithId(id: Int): ViewAction {

        return object : ViewAction {
            override fun getDescription(): String {
                return "Click on a child view with specified id."
            }

            override fun getConstraints(): Matcher<View>? {
                return null
            }

            override fun perform(uiController: UiController?, view: View) {
                val v: View = view.findViewById(id)
                v.performClick()

            }
        }

    }
}
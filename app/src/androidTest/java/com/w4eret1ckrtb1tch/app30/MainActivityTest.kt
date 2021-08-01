package com.w4eret1ckrtb1tch.app30

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MainActivityTest {
    @get:Rule
    val mainActivity: ActivityTestRule<MainActivity?>? = ActivityTestRule(MainActivity::class.java)

    private val edit: Matcher<View> = ViewMatchers.withId(R.id.edit_text1)
    private val button: Matcher<View> = ViewMatchers.withId(R.id.button1)

    @Test
    fun checkIfButtonIsDisabled() {

       Espresso.onView(ViewMatchers.withId(R.id.button1)).check(ViewAssertions.matches(ViewMatchers.isNotEnabled()))
    }


    @Test
    fun checkIfButtonIsActivatedWhenEnteringText() {

        Espresso.onView(edit).perform(typeText("Hello world!!!"))
        closeSoftKeyboard()
        Espresso.onView(button).check(ViewAssertions.matches(ViewMatchers.isEnabled()))
        Espresso.onView(button).perform(click())
        Espresso.onView(edit).perform(clearText())
        Espresso.onView(button).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isEnabled())))
    }
}
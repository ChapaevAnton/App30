package com.w4eret1ckrtb1tch.app30

import android.view.View
import android.widget.EditText
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matcher
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

    private val edit: Matcher<View> = withId(R.id.edit_text1)
    private val button: Matcher<View> = withId(R.id.button1)

    @Test
    fun checkIfButtonIsDisabled() {

        onView(withId(R.id.button1)).check(matches(isNotEnabled()))
    }


    @Test
    fun checkIfButtonIsActivatedWhenEnteringText() {

        onView(edit).perform(typeText("Hello world!!!"))
        closeSoftKeyboard()
        onView(button).check(matches(isEnabled()))
        onView(button).perform(click())
        onView(edit).perform(clearText())
        onView(button).check(matches(isNotEnabled()))
    }
}
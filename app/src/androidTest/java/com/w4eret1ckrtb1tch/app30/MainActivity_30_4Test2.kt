package com.w4eret1ckrtb1tch.app30


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivity_30_4Test2 {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity_30_4::class.java)

    @Test
    fun mainActivity_30_4Test2() {
        val materialCheckBox = onView(
            allOf(
                withId(R.id.checkbox_item), withText("check box# 1"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.recycler_view),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        materialCheckBox.perform(click())


        val appCompatEditText1 = onView(
            allOf(
                withId(R.id.edit_text_item), withText(""),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.recycler_view),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText1.perform(click())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.edit_text_item), withText(""),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.recycler_view),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("test"))

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.edit_text_item), withText("test"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.recycler_view),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(closeSoftKeyboard())

        val checkBox = onView(
            allOf(
                withId(R.id.checkbox_item), withText("check box# 1"),
                withParent(withParent(withId(R.id.recycler_view))),
                isDisplayed()
            )
        )
        checkBox.check(matches(isDisplayed()))

        val editText = onView(
            allOf(
                withId(R.id.edit_text_item), withText("test"),
                withParent(withParent(withId(R.id.recycler_view))),
                isDisplayed()
            )
        )
        editText.check(matches(withText("test")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}

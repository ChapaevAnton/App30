package com.w4eret1ckrtb1tch.app30

import android.util.DisplayMetrics
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.math.roundToInt


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivity_30_4Test {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity_30_4::class.java)

    @Test
    fun recyclerViewTest() {
        Espresso.onView(ViewMatchers.withId(R.id.recycler_view))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerAdapter.ItemViewHolder>(
                    10,
                    ViewActions.scrollTo()
                )
            )
    }

    @Test
    fun recyclerViewItemClickCheckBox() {

        for (position in 0..8) {

            Espresso.onView(ViewMatchers.withId(R.id.recycler_view)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerAdapter.ItemViewHolder>(
                    position,
                    clickItemWithId(R.id.checkbox_item)
                )
            )
        }

    }


    @Test
    fun recyclerViewItemFieldEditText() {

        for (position in 0..8) {

            Espresso.onView(ViewMatchers.withId(R.id.recycler_view)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerAdapter.ItemViewHolder>(
                    position,
                    editItemWithId(R.id.edit_text_item)
                )
            )
        }
    }

    //???????? ???????????? ?? ????????
    private fun editItemWithId(id: Int): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return Matchers.any(View::class.java)
            }

            override fun getDescription(): String {
                return "Edit text field view with specified id"
            }

            override fun perform(uiController: UiController?, view: View?) {
                val v = view?.findViewById(id) as EditText
                v.setText("Hello world!!!")
            }

        }
    }

    //?????????????? ??????????, ?????????????? ???????????????????? ???????????? ViewAction - ???????? ???? CheckBox
    private fun clickItemWithId(id: Int): ViewAction {
        //?????????????? ?????????????????? ??????????, ?????????????????????? ?????????????????? ViewAction
        return object : ViewAction {
            //?????????? ???? ?????????? ???????????????????? ??????????-???????? ?????????????????????? ?????? ???????????????? ?? ?????????????? Matcher
            //????????????????, ?????????? View ?????? ?????????? ???? ????????????
            override fun getConstraints(): Matcher<View>? {
                return Matchers.any(View::class.java)
            }

            //?? ???????? ???????????? ???? ???????????????????? ???????????????? ????????????????, ?????? ???????????? ???????? ????????????????????
            override fun getDescription(): String {
                return "Click on a child view with specified id."
            }

            //?? ???????? ???????????? ?????????????????? ???????????????? ?????? View
            override fun perform(uiController: UiController, view: View) {
                val v = view.findViewById(id) as CheckBox
                v.performClick()
            }
        }
    }

    // TODO: 02.08.2021 UI Automator
    @Test
    fun openNotifications() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.openNotification()
        Thread.sleep(1500)
        device.pressBack()
        device.openNotification()
        Thread.sleep(1500)
        device.click(dpToPx(100), dpToPx(100))
    }

    private fun dpToPx(dp: Int): Int {
        val displayMetrics: DisplayMetrics =
            InstrumentationRegistry.getInstrumentation().context.resources.displayMetrics
        return (dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
    }


    @Test
    fun openPhone() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        //???????????????? ???????????? ?????????????????? ????????????, ???? ???????????? ???????? ???? ?????????? ?????????? ???? ?????????? ?????????????????? ?? ???????????? ??????????
        device.pressHome()

        //?????????????? ???????? ???????????????????? ???? description
        val launcher: UiObject = device.findObject(UiSelector().description("Phone"))
        //?????????????? ???? ???????????? ?? ????????, ???????? ????????????????????
        launcher.clickAndWaitForNewWindow()
    }

    @Test
    fun rotationDevice() {
        val device = UiDevice.getInstance((InstrumentationRegistry.getInstrumentation()))

        device.setOrientationRight()
        Thread.sleep(1500)
        device.setOrientationNatural()
        Thread.sleep(1500)
        device.setOrientationLeft()
        Thread.sleep(1500)
        device.setOrientationNatural()
    }

}


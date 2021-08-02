package com.w4eret1ckrtb1tch.app30

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
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


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

    //Ввод данных в поле
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

    //Создаем метод, который возвращает объект ViewAction - клик по CheckBox
    private fun clickItemWithId(id: Int): ViewAction {
        //Создаем анонимный класс, реализующий интерфейс ViewAction
        return object : ViewAction {
            //Здесь мы можем установить какие-либо ограничения для проверки с помощью Matcher
            //например, чтобы View был виден на экране
            override fun getConstraints(): Matcher<View>? {
                return Matchers.any(View::class.java)
            }

            //В этом методе мы возвращаем описание действия, оно должно быть лаконичным
            override fun getDescription(): String {
                return "Click on a child view with specified id."
            }

            //В этом методе совершаем действие над View
            override fun perform(uiController: UiController, view: View) {
                val v = view.findViewById(id) as CheckBox
                v.performClick()
            }
        }
    }
}
package evan.chen.tutorial.tdd.uitestsample

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.RootMatchers.isDialog
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

@LargeTest
class RegisterTest {

    @Rule
    @JvmField
    var activityActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun rightPassword_should_startActivity() {

        //輸入正確的帳密
        inputRightRegisterData()

        //點選註冊按鈕
        onView(withId(R.id.send)).perform(click())

        //註冊成功，導至成功頁。
        onView(withText("註冊成功")).check(matches(isDisplayed()))
    }

    private fun inputRightRegisterData() {
        //輸入帳號
        onView(withId(R.id.loginId)).perform(typeText("a123456789"), ViewActions.closeSoftKeyboard())
        //輸入密碼
        onView(withId(R.id.password)).perform(typeText("a111111111"), ViewActions.closeSoftKeyboard())
    }

    @Test
    fun wrongPassword_should_alert() {

        inputWrongRegisterData()

        //點選註冊按鈕
        onView(withId(R.id.send)).perform(click())

        //註冊失敗，Alert
        onView(withText("錯誤"))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))

    }

    private fun inputWrongRegisterData() {
        //輸入帳號
        onView(withId(R.id.loginId)).perform(typeText("a123456789"), ViewActions.closeSoftKeyboard())

        //輸入密碼
        onView(withId(R.id.password)).perform(typeText("1234"), ViewActions.closeSoftKeyboard())
    }
}
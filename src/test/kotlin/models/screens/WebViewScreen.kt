package models.screens

import io.appium.java_client.AppiumBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import util.AppiumDriverExtension
import java.time.Duration

class WebViewScreen {

    val androidDriver= AppiumDriverExtension.androidDriver
    val androidDriverWait = WebDriverWait(androidDriver, Duration.ofSeconds(10))

    private val loadingScreen = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"load_page\")")

    fun webViewVisibility(): Boolean{
        println("Test started")
        try {
            androidDriverWait.until(ExpectedConditions.visibilityOfElementLocated(loadingScreen))
            return true
        }catch (e: Exception){
            return false
        }
        println("wait finished")
//        return androidDriver.findElement(loadingScreen).isDisplayed
    }
}
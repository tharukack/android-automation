package org.example

import io.appium.java_client.AppiumBy
import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.net.URL
import java.sql.Time
import java.util.concurrent.TimeUnit
import kotlin.time.Duration

fun main() {
    val name = "Kotlin"

//    var capabilities = DesiredCapabilities()
//
//    capabilities.setCapability("deviceName","sdk_gphone_x86")
//    capabilities.setCapability("udid","emulator-5554")
//    capabilities.setCapability("platformName","Android")
//    capabilities.setCapability("platformVersion","11")
//    capabilities.setCapability("automationName","uiAutomator2")
//    capabilities.setCapability("appPackage","com.qmatic.kiosk")
//    capabilities.setCapability("appActivity","com.qmatic.kiosk.app.MainActivity")
//
//    val url = URL("http://127.0.0.1:4723/")
//
//    val driver = AppiumDriver(url,capabilities)

    var options = UiAutomator2Options()
        .setUdid("emulator-5554")
        .setApp("C:\\Builds\\KioskAutomation\\app\\Qmatic Kiosk-1.6.2[3]-release.apk");
    var driver = AndroidDriver(URL("http://127.0.0.1:4723"), options)
    try {
//        WebElement el = driver.findElement(AppiumBy.xpath("//Button"));
//        el.click();
        driver.findElement(AppiumBy.ByAndroidUIAutomator("UiSelector().className(\"android.widget.EditText\").instance(0)")).sendKeys("10.20.1.6")
        driver.findElement(AppiumBy.ByAndroidUIAutomator("UiSelector().className(\"android.widget.EditText\").instance(2)")).sendKeys("BR1")
        driver.findElement(AppiumBy.ByAndroidUIAutomator("UiSelector().className(\"android.widget.EditText\").instance(3)")).sendKeys("KION1")
        val toggleSwitch = driver.findElement(AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.View\").instance(9)"))
        if (toggleSwitch.isEnabled){
            toggleSwitch.click()
        }
        driver.findElement(AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\")")).click()


//        val wait = WebDriverWait(driver, java.time.Duration.ofSeconds(10))
            Thread.sleep(10000)
//        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"canvas0\")")))
        driver.findElement(AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"button_0\")")).click()

    } finally {
//        driver.quit();
    }
}
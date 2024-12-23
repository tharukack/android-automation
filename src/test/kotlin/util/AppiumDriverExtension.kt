package util

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import io.appium.java_client.service.local.AppiumDriverLocalService
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.time.Duration

object AppiumDriverExtension {

    lateinit var androidDriver: AndroidDriver
    private lateinit var service: AppiumDriverLocalService


    @Throws(Exception::class)
    fun connectAppium(){
        println("Connecting to appium server")
        var capabilities = DesiredCapabilities()
//        capabilities.setCapability("platformName", "Android")
//        capabilities.setCapability("platformVersion", "13")
//        capabilities.setCapability("deviceName", "emulator-5554")
//        capabilities.setCapability("appPackage", "com.qmatic.kiosk")
//        capabilities.setCapability("appActivity", "com.qmatic.kiosk.MainActivity")
//        capabilities.setCapability("automationName", "UiAutomator2")

//        startAppiumServer()
//        val serviceURL = service.url.toString()
//        println("Appium Service Address: " + serviceURL)


        val options = UiAutomator2Options()
            .setUdid("emulator-5554")
            .setApp("C:\\Builds\\KioskAutomation\\app\\kiosk.apk")

        androidDriver = AndroidDriver(URL("http://127.0.0.1:4723/"),options)
//        androidDriver = AndroidDriver(URL(serviceURL),options)
//        androidDriver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30))
    }

     fun close(){
         androidDriver.close()
//         stopAppiumServer()
    }


    private fun startAppiumServer(){
        service = AppiumDriverLocalService.buildDefaultService()
        if (!service.isRunning){
            service.start()

        }
    }
    private fun stopAppiumServer(){
        service.stop()
    }
}
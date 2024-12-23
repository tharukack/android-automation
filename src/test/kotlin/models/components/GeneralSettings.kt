package models.components

import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import util.AppiumDriverExtension
import java.time.Duration

class GeneralSettings {

    val androidDriver= AppiumDriverExtension.androidDriver
    val androidDriverWait = WebDriverWait(androidDriver, Duration.ofSeconds(10))

    private val serverIPTxtBox = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private val websocketPortTxtBox = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private val brPrefixTxtBox = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)")
    private val unitIDTxtBox = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)")
    private val sslSwitch = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(9)")
    private val connectBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\")")


    private fun serverIP(): WebElement{
        androidDriverWait.until(ExpectedConditions.visibilityOfElementLocated(serverIPTxtBox))
        return androidDriver.findElement(serverIPTxtBox)
    }
    private fun websocketPort(): WebElement{
        return androidDriver.findElement(websocketPortTxtBox)
    }
    private fun brPrefix(): WebElement{
        return androidDriver.findElement(brPrefixTxtBox)
    }
    private fun unitID(): WebElement{
        return androidDriver.findElement(unitIDTxtBox)
    }
    private fun ssl(): WebElement{
        return androidDriver.findElement(sslSwitch)
    }
    private fun connect(): WebElement{
        return androidDriver.findElement(connectBtn)
    }

    fun inputIP(value:String): GeneralSettings{
        serverIP().sendKeys(value)
        return this
    }

    fun inputWebsocketPort(value:Int): GeneralSettings{
        websocketPort().sendKeys(value.toString())
        return this
    }

    fun inputBrPrefix(value: String): GeneralSettings{
        brPrefix().sendKeys(value)
        return this
    }

    fun inputUnitID(value: String): GeneralSettings{
        unitID().sendKeys(value)
        return this
    }

    fun disableSsl(value:Boolean): GeneralSettings{
        if (ssl().isEnabled){
            if (value){
                ssl().click()
            }
        }else{
            if (!value){
                ssl().click()
            }
        }

        return this
    }

    fun pressConnect(): GeneralSettings{
        connect().click()
        return this
    }
}
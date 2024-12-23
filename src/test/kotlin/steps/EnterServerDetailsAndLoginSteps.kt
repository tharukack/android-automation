package steps

import com.sun.org.apache.xpath.internal.operations.Bool
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import models.screens.SettingsScreen
import models.screens.WebViewScreen
import util.AppiumDriverExtension
import kotlin.test.assertEquals

class EnterServerDetailsAndLoginSteps {

    val settingsScreen = SettingsScreen()
    val webViewScreen = WebViewScreen()

    @Given("Ip is {string}")
    fun pipIs( string: String) {
        settingsScreen.generalSettings.inputIP(string)
    }
    @And("SSL switch is {string}")
    fun sslIs(string: String) {
        if (string.lowercase() == "enabled"){
            settingsScreen.generalSettings.disableSsl(false)
        }else if (string.lowercase() == "disabled"){
            settingsScreen.generalSettings.disableSsl(true)
        }
    }
    @And("Port is {int}")
    fun portIs(int: Int) {
        settingsScreen.generalSettings.inputWebsocketPort(int)
    }
    @And("BranchPrefix is {string}")
    fun branchPrefixIs(string: String) {
        settingsScreen.generalSettings.inputBrPrefix(string)
    }
    @And("UnitID is {string}")
    fun unitIDIs(string: String) {
        settingsScreen.generalSettings.inputUnitID(string)
    }
    @When("User press the Connect Button")
    fun userPressTheConnectButton() {
        settingsScreen.generalSettings.pressConnect()
    }
    @Then("User will be navigated to webview")
    fun userWillBeNavigatedToWebview() {
        assertEquals(webViewScreen.webViewVisibility(),true)
    }

}

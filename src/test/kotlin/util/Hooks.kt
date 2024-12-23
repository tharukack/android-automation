package util

import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.BeforeAll

class Hooks {

    @Before
    fun startDevice() {
        AppiumDriverExtension.connectAppium()
    }

    @After
    fun stopConnection(){
//        AppiumDriverExtension.close()
    }
}
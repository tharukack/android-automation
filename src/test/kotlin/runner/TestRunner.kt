package runner

import io.cucumber.core.snippets.SnippetType
import io.cucumber.testng.AbstractTestNGCucumberTests
import io.cucumber.testng.CucumberOptions


@CucumberOptions(
    features = ["src/test/kotlin/features"],
//    dryRun = true,
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    monochrome = true,
    glue = ["util","steps"],
    plugin = ["pretty","html:reports/KioskReport.html"]
)
class TestRunner: AbstractTestNGCucumberTests() {
}
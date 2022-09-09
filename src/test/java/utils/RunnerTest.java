package utils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",
        glue = "by.diploma.steps",
        plugin = { "pretty", "html:target/cucumber.html",
                "json:target/cucumber.json"})
public class RunnerTest extends AbstractTestNGCucumberTests {
}

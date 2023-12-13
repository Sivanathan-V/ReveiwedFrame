package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\svaithyanathan\\IdeaProjects\\ReviewedFrame\\src\\main\\resources\\features\\API", dryRun = false, tags = (""), glue = "steps\\API", plugin = {
        "pretty", "json:target\\APIOutput.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true)
public class TestRunner {

}

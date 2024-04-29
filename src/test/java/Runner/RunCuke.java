package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features"}, glue = {"steps"}
        , plugin = {"html:target/cucumber-html-reports/cucumber-html-report.html"
        , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter: "})
public class RunCuke extends AbstractTestNGCucumberTests {
}

//@prod or @func and not @staging
/*
//Maven Update -
    Build, Execution, Deployment > Repositories > Select maven > Update*/

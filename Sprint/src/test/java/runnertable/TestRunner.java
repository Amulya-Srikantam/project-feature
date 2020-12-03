package runnertable;


import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

//import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions( features = {"features/Signin.feature" },
glue={"StepDefTable"} ,
monochrome = true,
//tags= {"@google"},
//plugin = {"html:target/Destination"},
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})

public class TestRunner extends AbstractTestNGCucumberTests {
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig("src/extent-config.xml");
    }

}

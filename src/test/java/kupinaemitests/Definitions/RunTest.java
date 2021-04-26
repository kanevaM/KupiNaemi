package kupinaemitests.Definitions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(plugin = {"progress", "html:target/cucumber-html-report"},
        features = "src/test/java/kupinaemitests/features")


public class RunTest extends AbstractTestNGCucumberTests{

}







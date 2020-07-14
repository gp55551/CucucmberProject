package Test;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( dryRun = false,
		features = "src\\Features\\FirstCucumber5.feature"	,glue={"stepDefinition"},
		monochrome=true
		//,format = {"pretty"}
		//,format = {"html:D:\\Results"}

	
		)

public class TestRunner {

}
package com.sqa.prueba;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
//import net.serenitybdd.cucumber.CucumberWithSerenity;
//
//import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
       features = "src/test/resources/features",
       glue = {"com.sqa.prueba.stepdef"},
       tags = {"~@Ignore"},
       plugin = {
               "pretty",
               "html:target/cucumber-reports/cucumber-pretty",
               "json:target/cucumber-reports/json-reports/CucumberTestReport.json",
               "rerun:target/cucumber-reports/rerun-reports/rerun.txt"
       })

//@RunWith(CucumberWithSerenity.class)
public class TestRunner {
	private TestNGCucumberRunner testNGCucumberRunner;
		
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
	    testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	 
	 @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features", invocationCount = 1)
//	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
	    testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	 
	@DataProvider
	public Object[][] features() {
	    return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
	    testNGCucumberRunner.finish();
	}
	
}

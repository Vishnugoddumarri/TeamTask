package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(
        features = "C:\\Users\\vishnu\\IdeaProjects\\BigBasket\\src\\test\\java\\features\\login.feature"//the path of the feature files
        , glue={"stepdefination"},
        tags = {"~@Ignore"},
        format= {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/cucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        },plugin = "json:target/cucumber-reports/cucumberTestReport.json")

public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception{
        testNGCucumberRunner= new TestNGCucumberRunner(this.getClass());

    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature){
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features(){
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass
   public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();

    }

}

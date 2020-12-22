package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\vishnu\\IdeaProjects\\BigBasket\\src\\test\\java\\features\\login.feature"//the path of the feature files
        , glue={"stepdefination"}
       // format= {"Report","html:test-outout"}
)

public class TestRunner {

}

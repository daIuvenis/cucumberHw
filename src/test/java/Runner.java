import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/TempMailTest.feature"},
        glue = {"Steps"},
        plugin = {"pretty", "json:target/runner.json", "junit:target/junit.xml"},
        tags = {"@C1"}
)
public class Runner {
}

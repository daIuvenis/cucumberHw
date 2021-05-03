import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"},
        glue = {"Steps"},
        plugin = {"pretty", "json:target/runner.json", "junit:target/junit.xml"},
        tags = {"@C1"}
)
public class Runner {
}

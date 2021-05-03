import Core.DriverFactory;
import cucumber.api.java.AfterStep;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;

public class Hooks {
    @Before
    public void setUp() {
        DriverFactory.initialize();
    }

    @AfterEach
    public void finish() {
        DriverFactory.quit();
    }
}

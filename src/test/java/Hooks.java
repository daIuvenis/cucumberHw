import Core.DriverFactory;
import org.junit.After;
import org.junit.Before;

public class Hooks {
    @Before
    public void setUp() {
        DriverFactory.initialize();
    }

    @After
    public void finish() {
        DriverFactory.quit();
    }
}

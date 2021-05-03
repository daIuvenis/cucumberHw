package Steps;

import Interfaces.ITempMail;
import Pages.TempMail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Steps {
    protected final Logger log = LogManager.getLogger(this.getClass());
    ITempMail iTempMail = new TempMail();
}

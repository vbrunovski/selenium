package OWASP_ZAP;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import org.zaproxy.clientapi.core.ClientApiException;


@Slf4j
public class SampleTest extends BaseSecurity {

    //private static final String REG_URL = "https://juice-shop.herokuapp.com/";
    private static final String REG_URL = "https://firmast.ee/";

    @Test()
    public void scanRegPage() throws ClientApiException {
        getDriver().get(REG_URL);
        // some more logic using page object goes here
        checkRiskCount(REG_URL);
    }
}
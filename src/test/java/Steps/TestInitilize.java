package Steps;

import Utilities.RestAssuredExtension;
import io.cucumber.java.Before;

public class TestInitilize {
    @Before
    public void TestStepup(){
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();


    }
}

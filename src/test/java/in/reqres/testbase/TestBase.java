package in.reqres.testbase;

import in.reqres.utils.TestUtils;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by Jay Vaghani
 */
public class TestBase extends TestUtils {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://reqres.in";

        RestAssured.basePath = "/api/";

    }
}

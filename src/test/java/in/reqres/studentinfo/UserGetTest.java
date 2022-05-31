package in.reqres.studentinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserGetTest extends TestBase {
    @Test
    public void getListOfUsers() {

        Response response = given()
                .queryParam("page", 2)
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void GetSingleUser() {
        Response response = given()
                .when()
                .get("/users/2");

        response.then().statusCode(200);
        response.prettyPrint();

    }
}

package in.reqres.studentinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserDeleteTest extends TestBase {
    @Test
            public void deleteUser(){
    Response response = given()
            //.header("content-Type", "application/jason")
            .pathParam("id", 2)
            .when()
            .delete("/{id}");
    response.then().statusCode(204);
        response.prettyPrint();
}
}



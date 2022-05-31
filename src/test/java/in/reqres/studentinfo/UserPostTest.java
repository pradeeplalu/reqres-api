package in.reqres.studentinfo;

import in.reqres.model.PojoClass;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserPostTest extends TestBase {
    @Test
    public void createNewUser(){
        PojoClass studentPojo = new PojoClass();
        studentPojo.setName("morpheus");
        studentPojo.setJob("leader");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();


    }
    @Test
    public void sendLogIn() {


        PojoClass userPojo = new   PojoClass();
        userPojo.setEmail("eve.holt@reqres.in");
        userPojo.setPassword("cityslicka1");

        Response response = given()
                .header("Authorization","Bearer b5f2ee3fca5b4efacce265745546d4fd7f1501611b151cf408ac45f7648bb5d0")
                .header("Content-Type","application/json")
                .body(userPojo)
                .when()
                .post("/login");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}



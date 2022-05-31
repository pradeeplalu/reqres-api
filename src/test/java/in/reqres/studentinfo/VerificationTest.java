package in.reqres.studentinfo;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class VerificationTest {

    static ValidatableResponse response;
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";

        response = given()
                .queryParam("page", 2)
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    //verify that page = 2
    @Test
    public void test001() {
        int page = response.extract().path("page");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Page = " + page);
        System.out.println("------------------End of Test---------------------------");
    }
    //per_page = 6
    @Test
    public void test002(){
        int per_page = response.extract().path("per_page");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" per_page = " + per_page);
        System.out.println("------------------End of Test---------------------------");
    }
    //data[1].id = 8
    @Test
    public void test003(){
        int number = response.extract().path("data[1].id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" data[1].id = " + number);
        System.out.println("------------------End of Test---------------------------");
    }
    //data[3].first_name = Byron
    @Test
    public void test004(){
        String name = response.extract().path("data[3].first_name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" data[3].first_name = " + name);
        System.out.println("------------------End of Test---------------------------");
    }
    //list of data = 6
    @Test
    public void test005(){
        int listOfData = response.extract().path("data.size");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" list of data = " + listOfData);
        System.out.println("------------------End of Test---------------------------");
    }
    //data[5].avatar="https://reqres.in/img/faces/11-image.jpg"
    @Test
    public void test006(){
        String avatar = response.extract().path("data[5].avatar");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" data[5].avatar = " + avatar);
        System.out.println("------------------End of Test---------------------------");
    }
    // support.url ="https://reqres.in/#support-heading"
    @Test
    public void test007(){
        String url = response.extract().path("support.url");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" support.url = " + url);
        System.out.println("------------------End of Test---------------------------");
    }
    // support.txt = "To keep ReqRes free, contributions towards server costs are appreciated!"
    @Test
    public void test008(){
        String txt = response.extract().path("support.text");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" support.txt = " + txt);
        System.out.println("------------------End of Test---------------------------");
    }

}




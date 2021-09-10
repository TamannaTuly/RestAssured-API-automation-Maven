import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class TestGet01 {
    @Test
    void testget01(){

        Response response = get("https://jsonplaceholder.typicode.com/posts/1");

        int statusCode=response.getStatusCode();

        Assert.assertEquals(statusCode,201);
    }

    @Test
    void testget02(){
        given().get("https://jsonplaceholder.typicode.com/posts/1").then().statusCode(201);
    }


}

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class localApi {
    @Test
    public void localapi(){
        JSONObject request = new JSONObject();

        request.put("firstName","morpheus");
        request.put("lastName","leader2");
        request.put("subjectId","2");

        System.out.println(request);

        baseURI="http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().all();
    }

    @Test
    public void dele(){
        baseURI="http://localhost:3000/";
        given().
                delete("/users/li68N7W").
                then().
                statusCode(404).
                log().all();
    }
}

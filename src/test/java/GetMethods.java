import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetMethods {

    //@Test
    public void getCases01(){
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200).
                body("data.id[0]", Matchers.equalTo(7)).
                log().all();
    }

    //testtutorial

    //@Test
    public void getcase2(){
        Response response=null;

        response= RestAssured
                .given()
                .get("https://reqres.in/api/users?page=2");

        if(response.statusCode()==200){
            System.out.println("Success");
        }

    }
    @Test
    public void postone(){
        JSONObject request = new JSONObject();

        request.put("name","morpheus");
        request.put("job","leader");

        System.out.println(request);

        Response response=null;
        response= RestAssured.
        given().
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/");
//                then().
//                statusCode(201).
//                log().all();

        if(response.statusCode()==201){
            System.out.println(response.statusCode()+"tamanna u did it");
        }
        else {
            System.out.println(response.statusCode()+"tamanna there's an error");
        }
    }


}

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DataProviderTest extends DataSetforTest{




//    @Test(dataProvider = "data for post")
    public void localapi(String firstName, String lastName, int subjectId){
        JSONObject request = new JSONObject();

        request.put("firstName",firstName);
        request.put("lastName",lastName);
        request.put("subjectId",subjectId);

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


//    @DataProvider(name = "data for delete")
//    public Object[] datafordelete(){
//        return new Object[]{
//                1,2
//        };
//    }
//
    @Parameters("userId")
    @Test
    public void dele(int userId){
        baseURI="http://localhost:3000/";
        given().
                delete("/users/"+userId).
                then().
                statusCode(200).
                log().all();
    }
}

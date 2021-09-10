import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteMethods {

    @Test
    public void deleteCases01(){
        given().
                delete("https://reqres.in/api/users/2").
                then().
                statusCode(204).
                log().all();
    }
}

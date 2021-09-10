package DataUtility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestCaseforWriting {
    @Test
    public void postTest01() throws Exception {
        String excelPath = "./Data/TestData.xlsx";
        String sheetName = "Sheet1";

        ExcelUtilities excelUtilities = new ExcelUtilities(excelPath,sheetName);
        WriteMethod writeMethod=new WriteMethod();

        Object firstName = excelUtilities.getCelldata(1,0);
        Object lastName = excelUtilities.getCelldata(1,1);
        Object subjectId = excelUtilities.getCelldata(1,2);


        JSONObject request = new JSONObject();

        request.put("firstName",firstName);
        request.put("lastName",lastName);
        request.put("subjectId",subjectId);

        System.out.println(request);

        baseURI="http://localhost:3000/";


        RequestSpecification requestSpecification= RestAssured.given();
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.body(request.toJSONString());

        Response response=requestSpecification.post("/users");

        if(response.statusCode()==201){
            writeMethod.writeIntoExcel(excelPath,1,3,"Success");
            writeMethod.writeIntoExcel(excelPath,1,4,response.asPrettyString());
        }
        else {
            writeMethod.writeIntoExcel(excelPath,1,3,"Failed");
        }




//        given().
//                contentType(ContentType.JSON).
//                accept(ContentType.JSON).
//                header("Content-Type", "application/json").
//                body(request.toJSONString()).
//                when().
//                post("/users").
//                then().
//                statusCode(201).
//                log().all();
    }
}

package DataUtility;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static DataUtility.ExcelRW.writesomething;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TryingOutsomething{
        @Test
        public void Test1() throws FileNotFoundException {
            String excelPath = ".1/Data/TestPractice.xlsx";
            String sheetName = "Sheet1";
//            String dataPath = "./Data/ReadWriteData.xlsx";

            ExcelUtilities excelUtilities = new ExcelUtilities(excelPath, sheetName);
//            ExcelRW writing=new ExcelRW();

            Object firstName = excelUtilities.getCelldata(1, 0);
            Object lastName = excelUtilities.getCelldata(1, 1);
            Object subjectId = excelUtilities.getCelldata(1, 2);


            JSONObject request = new JSONObject();

            request.put("firstName", firstName);
            request.put("lastName", lastName);
            request.put("subjectId", subjectId);

            System.out.println(request);

            baseURI = "http://localhost:3000/";


            RequestSpecification req = given();
            req.contentType(ContentType.JSON);
            req.accept(ContentType.JSON);
            req.header("Content-Type", "application/json");
            req.body(request.toJSONString());
            System.out.println(request);
//                    .contentType(ContentType.JSON).
//                    accept(ContentType.JSON).
//                    header("Content-Type", "application/json").
//                    body(request.toJSONString()).
//                    when().
//                    post("/users").
//                    then().
//                    statusCode(201).
//                    log().all();

            Response response=req.post("/users");
//            System.out.println(req.body().asString());
//            System.out.println(req.statusCode());

            if (response.statusCode() == 201) {

                writesomething(excelPath,"PASS",1,7);
                writesomething(excelPath,response.body().prettyPrint(),1,8);
            }
            else {

                writesomething(excelPath,"Failed",1,7);
                writesomething(excelPath,response.body().toString(),1,8);
            }
//
//        if (resp){
//            System.out.println("SuCcESS");
//        }
//        else {
//            System.out.println("Failed");
//        }

//         Response response= (Response) request.get("http://localhost:3000/users");
//
//         if (response){
//
//         }

        }
}

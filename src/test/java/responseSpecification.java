//import DataUtility.ExcelUtilities;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.json.simple.JSONObject;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.baseURI;
//import static io.restassured.RestAssured.given;
//
//public class responseSpecification {
//    @Test
//    public void Test1(){
//        String excelPath = "./Data/TestData.xlsx";
//        String sheetName = "Sheet1";
//
//        ExcelUtilities excelUtilities = new ExcelUtilities(excelPath,sheetName);
//
//        Object firstName = excelUtilities.getCelldata(1,0);
//        Object lastName = excelUtilities.getCelldata(1,1);
//        Object subjectId = excelUtilities.getCelldata(1,2);
//
//
//        JSONObject request = new JSONObject();
//
//        request.put("firstName",firstName);
//        request.put("lastName",lastName);
//        request.put("subjectId",subjectId);
//
//        System.out.println(request);
//
//        baseURI="http://localhost:3000";
//
//
//        RequestSpecification req = RestAssured.given();
//        req.body(request.toString());
//
//        Response resp=RestAssured.post("/users");
//
//        System.out.println("status code is :" + resp.statusCode());
//
//        if (resp.statusCode()==201){
////            excelUtilities.setCelldata(1,3);
////            excelUtilities.setCelldata(1,4);
////            excelUtilities.setCelldata(1,5);
//            excelUtilities.inputData();
//        }
//        else {
//            excelUtilities.failedtoInput();
//        }
//
//
////        given().
////                contentType(ContentType.JSON).
////                accept(ContentType.JSON).
////                header("Content-Type", "application/json").
////                body(request.toJSONString()).
////                when().
////                post("/users").
////                then().
////                statusCode(201).
////                log().all();
////
////        if (resp){
////            System.out.println("SuCcESS");
////        }
////        else {
////            System.out.println("Failed");
////        }
//
////         Response response= (Response) request.get("http://localhost:3000/users");
////
////         if (response){
////
////         }
//
//    }
//}

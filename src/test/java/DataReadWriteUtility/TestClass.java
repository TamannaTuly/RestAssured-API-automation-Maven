package DataReadWriteUtility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestClass {

    MethodofReadWrite methodofReadWrite = new MethodofReadWrite();

    @Test
    public void postUser() throws IOException{
       String dataPath = "./Data/ReadWriteData.xlsx";

       Object data1 = methodofReadWrite.ReadTestData(dataPath,1,0);
       String name=data1.toString();
       System.out.println(name);
       Object data2 = methodofReadWrite.ReadTestData(dataPath,1,1);
       String job=data2.toString();
        System.out.println(job);
       Object data3 = methodofReadWrite.ReadTestData(dataPath,1,2);
       String subjectId=data3.toString();
        System.out.println(subjectId);

        RestAssured.baseURI ="http://localhost:3000/";


        JSONObject bodyParam=new JSONObject();
        bodyParam.put("firstName",name);
        bodyParam.put("lastName",job);
        bodyParam.put("subjectId",subjectId);
//        bodyParam.put("subjectId",subjectId);

        RequestSpecification req = RestAssured.given();
        req.body(bodyParam.toString());
        System.out.println("body : "+req);

        Response response=req.post("users");

        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}

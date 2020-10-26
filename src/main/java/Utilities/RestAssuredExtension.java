package Utilities;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtension {
    public static RequestSpecification Request;

    public RestAssuredExtension(){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000");
        builder.setContentType(ContentType.JSON);
        var requestSpec = builder.build();
        Request= RestAssured.given().spec(requestSpec);
    }

    //act
    public void GetOpswithPathParameter(String uri, Map<String,String> pathParams){
        Request.pathParams(pathParams);
        try{
            Request.get(new URI(uri));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static ResponseOptions<Response> GetOps(String URL){
        try{
            return Request.get(URL);

        }  catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }
      public static ResponseOptions<Response> PostOpsWithBody(String url, Map<String, String> body){
        Request.body(body);
        return Request.post(url);
     }
    public static ResponseOptions<Response> PostOpsWithBodyandParam(String url, Map<String, String> body,Map<String, String> pathParams){
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.post(url);
    }

    public static ResponseOptions<Response> PUTOpsWithBody(String url, Map<String, String> body,Map<String, String>pathParams){
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.put(url);
    }

    public static ResponseOptions<Response> DeleteOpsWithPathParams(String url, Map<String, String> pathParams){
        Request.pathParams(pathParams);
        return Request.delete(url);
    }
    public static ResponseOptions<Response> GetOpsWithPathParams(String url, Map<String, String> pathParams)
    {
        Request.pathParams(pathParams);
        return Request.get(url);
    }

    public static ResponseOptions<Response> GetOPswithToken(String url, String Token){

         try{
             Request.header(new Header("Authorization","Bearer "+Token));
                return Request.get(url);
         }catch (Exception e){
             e.printStackTrace();
         }
        return null;
    }

}

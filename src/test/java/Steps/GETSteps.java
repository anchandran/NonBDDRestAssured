package Steps;

import Utilities.RestAssuredExtension;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.core.IsNot;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsIterableContaining.hasItems;

public class GETSteps {

    public static ResponseOptions<Response> response;

    @Given("Perform GET for id {string}")
    public void performGETForId(String id) {
//        given()
//                .contentType("ContentType.JSON").
//                with()
//                .pathParams("id",id).
//                when()
//                .get("http://localhost:3000/posts/{id}").
//                then()
//                .body("author",is("James"));

     //   response=restAssureExtension.GetOpswithPathParameter("http://localhost:3000/posts/",id);

    }


    @Given("Perform GET for all products")
    public void performGETForAllProducts() {
//        given()
//                .contentType("ContentType.JSON").
//        when()
//                .get("http://localhost:3000/posts/").
//        then()
//                .assertThat().body("author",hasItems("James"));

        response= RestAssuredExtension.GetOps("/posts");

    }

    @Then("I should see all product details")
    public void iShouldSeeAllProductDetails() {
        assertThat(response.getBody().jsonPath().get("author"),hasItems("James"));
    }

    @Given("Perform POST for id {string}")
    public void performPOSTForId(String id) {
        String url="/posts";
        HashMap<String, String > body= new HashMap<>();
        body.put("id",id);
        body.put("title","Rest Assured 25");
        body.put("author","Leo");

        response=RestAssuredExtension.PostOpsWithBody(url,body);

    }

    @Then("I should see the details of author {string}")
    public void iShouldSeeTheDetailsOfAuthor(String author) {
        assertThat(response.getBody().jsonPath().get("author"),is(author));
    }


    @Given("Perform POST for  all products")
    public void performPOSTForAllProducts(DataTable table) {
        String url="/posts";
        var data= table.asMaps();
        HashMap<String, String> postContent = new HashMap<String, String>();
        for (int i = 0; i < data.size(); i++){
            postContent.put("id", data.get(i).get("id"));
            postContent.put("title", data.get(i).get("title"));
            postContent.put("author", data.get(i).get("author"));
            response=RestAssuredExtension.PostOpsWithBody(url,postContent);
        }

    }


    @Then("I should see that added product detail has {string}")
    public void iShouldSeeThatAddedProductDetailHas(String title) {
        assertThat(response.getBody().jsonPath().get("title"),is(title));
    }




    @Given("Perform POST for the {string} all products")
    public void performPOSTForTheAllProducts(String url,DataTable table) {
        //String url="/posts";
        //System.out.print(url);
        var data= table.asMaps();
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("name",data.get(0).get("name"));
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("profileNo",data.get(0).get("profileNo"));
        response=RestAssuredExtension.PostOpsWithBodyandParam(url,body,param);
    }

    @Then("I should see name the {string}")
    public void iShouldSeeNameThe(String name) {

        assertThat(response.getBody().jsonPath().get("name"),is(name));
    }


    @Given("Perform Delete for the id {string}")
    public void performDeleteForTheId(String url,DataTable table) {
       // String url="/posts";
        var data= table.asMaps();
        System.out.println(data.get(0).get("id"));
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("id",data.get(0).get("id"));
        response=RestAssuredExtension.DeleteOpsWithPathParams(url,params);



    }

    @Then("I should see the details of author {string} is deleted")
    public void iShouldSeeTheDetailsOfAuthorIsDeleted(String name) {
        assertThat(response.getBody().jsonPath().get("name"),IsNot.not(name));
    }

    @Given("Perform PUT for the id {string}")
    public void performPUTForTheId(String url, DataTable table) {
        var data= table.asMaps();
      //  System.out.println(data.get(0).get("id"));
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("id",data.get(0).get("id"));
        body.put("title",data.get(0).get("title"));
        body.put("author",data.get(0).get("author"));
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("id",data.get(0).get("id"));
        response=RestAssuredExtension.PUTOpsWithBody(url,body,params);
    }

    @Then("I should see the details of author {string} is Updated")
    public void iShouldSeeTheDetailsOfAuthorIsUpdated(String author) {
        assertThat(response.getBody().jsonPath().get("author"),is(author));
    }
}

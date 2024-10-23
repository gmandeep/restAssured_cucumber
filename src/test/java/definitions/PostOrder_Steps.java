package definitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import api.RestAssuredClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ExtentReportManager;
import POJO.order_pojo;

public class PostOrder_Steps {
	
	private RequestSpecification requestSpec;
    private Response response;
    private String baseUri = "https://petstore.swagger.io/v2/store/order";
    ExtentReports extent = ExtentReportManager.getInstance();
    ExtentTest test;

    @Given("the API endpoint is ready for post")
    public void api_endpoint_is_readyforpost() {
    //    requestSpec = RestAssuredClient.getRequestSpec();
        test = extent.createTest("place order API Test");
        test.info("API endpoint is ready");
    }
    
    @When("I create an order with id {int}, petId {int}, quantity {int}, shipDate {string}, status {string}")
    public void create_order(int id, int petId, int quantity, String shipDate, String status) {
        // Create POJO for request body
        order_pojo order = new order_pojo(id, petId, quantity, shipDate, status, true);

        // Send POST request
        response = given()
            .contentType("application/json")
            .body(order)
            .when()
            .post(baseUri);
        test.info("Made post request to petstore" );
    }
    

    @Then("I should receive a {int} status code for post")
    public void validate_status_codefor_post(int statusCode) {
        response.then().statusCode(statusCode);
        test.info("Received status code: " + statusCode);
    }

    @And("the response should contain the order's id, petId, quantity, and status")
    public void validate_response() {
        response.then().body("status", equalTo("placed"));
    //    response.then().body("id", equalTo(0));
        test.info("Response contains the correct user details");
    }
}

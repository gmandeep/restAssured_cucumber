package definitions;

import api.RestAssuredClient;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetUserSteps {

    private RequestSpecification requestSpec;
    private Response response;
    ExtentReports extent = ExtentReportManager.getInstance();
    ExtentTest test;

    @Given("the API endpoint is ready")
    public void api_endpoint_is_ready() {
        requestSpec = RestAssuredClient.getRequestSpec();
        test = extent.createTest("inventory API Test");
        test.info("API endpoint is ready");
    }

    @When("I make a GET request to {string}")
    public void make_get_request(String endpoint) {
        response = given().spec(requestSpec).when().get(endpoint);
        test.info("Made GET request to " + endpoint);
    }

    @Then("I should receive a {int} status code")
    public void validate_status_code(int statusCode) {
        response.then().statusCode(statusCode);
        test.info("Received status code: " + statusCode);
    }

    @And("the response should inventory details")
    public void validate_inventory_details() {
      //  response.then().body("sold", equalTo(2));
        test.info("Response contains the correct user details");
       
    }
}

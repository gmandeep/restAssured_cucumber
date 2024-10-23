package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RestAssuredClient {

    private static RequestSpecification requestSpec;

    // Private constructor to prevent instantiation
    private RestAssuredClient() {}

    public static RequestSpecification getRequestSpec() {
        if (requestSpec == null) {
            requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io") // Set the base URL
                .setContentType("application/json")
                .build();
        }
        return requestSpec;
    }
}

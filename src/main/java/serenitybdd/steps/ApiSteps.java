package serenitybdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class ApiSteps {

    private Response response;

    @Given("the API is up and running")
    public void the_api_is_up_and_running() {
        // No specific setup needed for this simple test
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = RestAssured.get(endpoint);
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(int expectedStatusCode) {
        Assert.assertEquals("Unexpected status code!", expectedStatusCode, response.getStatusCode());
    }
}

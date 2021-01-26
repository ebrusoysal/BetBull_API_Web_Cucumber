package Steps;

import Pojo.UserData;
import Utilities.BaseAPI;
import Utilities.TestDataBuild;
import Utilities.UrlsEnum;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import java.io.IOException;
import static io.restassured.RestAssured.given;

public class APISteps extends BaseAPI {
    TestDataBuild dataBuild = new TestDataBuild();
    RequestSpecification reqSpec;
    Response response;
    UserData userData;


    @Given("Create successful registration payload")
    public void createSuccessfulRegistrationPayload() throws IOException {
        userData = dataBuild.validUser();
        reqSpec = given().spec(requestSpecification()).body(userData);
    }

    @When("user calls {string} with {string} http request")
    public void userCallsWithHttpRequest(String resource, String method) {
        UrlsEnum resourceAPI = UrlsEnum.valueOf(resource);
        switch (method) {
            case "POST":
                response = reqSpec.when().post(resourceAPI.getResource());
                break;
            case "GET":
                response = reqSpec.when().get(resourceAPI.getResource());
                break;
            case "DELETE":
                response = reqSpec.when().delete(resourceAPI.getResource());
                break;
            case "PUT":
                response = reqSpec.when().put(resourceAPI.getResource());
                break;
            default:
                break;
        }
    }

    @Then("API call is success with response code {int}")
    public void apiCallIsSuccessWithResponseCode(int statusCode) {
        ((ValidatableResponse)response.then()).statusCode(statusCode);
    }

    @And("A Token is created after successful registration")
    public void aTokenIsCreatedAfterSuccessfulRegistration() {
        String responseString = response.asString();
        JSONObject json = new JSONObject(responseString);
        Assert.assertTrue("", json.has("token"));
    }

    @Given("Create payload with {string} and {string}")
    public void createPayloadWithAnd(String email, String password) throws IOException {
        userData = dataBuild.invalidUser(email,password);
        reqSpec = given().spec(requestSpecification()).body(userData);
    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String key, String value) {
        Assert.assertEquals(getJsonPath(response, key), value);
    }

    @Given("Create request specifications")
    public void createRequestSpecifications() throws IOException {
        reqSpec = given().spec(requestSpecification());
    }

    @And("verify users are listed")
    public void verifyUsersAreListed() {
        JSONObject object = getJsonObject(response);
        Assert.assertNotEquals("User List is empty", "[]", object.get("data").toString());
    }

}

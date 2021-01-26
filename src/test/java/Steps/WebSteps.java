package Steps;

import com.framework.pages.HomePage;
import com.framework.pages.SignInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.io.IOException;

public class WebSteps {
    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();

    public WebSteps() throws IOException {
    }

    @Given("user landed on AutomationPractice.com home page")
    public void userLandedToAutomationPracticeHomePage() throws IOException {
        HomePage.navigateToHomePage();
    }

    @When("user clicks Sign In button on the home page")
    public void userClicksSignInButton() {
        homePage.clickSignIn();
    }

    @When("user signs in with {string} and {string} values")
    public void userSignsInWithAndValues(String email, String password) {
        signInPage.performSignIn(email, password);
    }

    @Then("An error message {string} is displayed on this page")
    public void userViewsOnThePage(String expectedValue) {
        String actualValue = signInPage.errorMessage.getText();
        Assert.assertEquals("Actual value is different than the expected value", expectedValue, actualValue);
    }

    @Then("user lands on Authentication Page")
    public void userLandsOnAuthenticationPage() {
        Assert.assertTrue(signInPage.authentication.isDisplayed());
    }
}

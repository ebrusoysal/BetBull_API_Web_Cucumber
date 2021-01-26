package com.framework.pages;

import com.framework.base.BaseWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;

public class SignInPage extends BaseWeb {
    @FindBy(xpath = "//div[@id='columns']//span[@class='navigation_page']")
    public WebElement authentication;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "passwd")
    public WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@id='center_column']//ol/li")
    public WebElement errorMessage;

    public SignInPage() throws IOException {
    }

    public void performSignIn(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
    }

}

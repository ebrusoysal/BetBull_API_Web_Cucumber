package com.framework.pages;

import com.framework.base.BaseWeb;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;

public class HomePage extends BaseWeb {
    @FindBy(className = "login")
    public WebElement signInButton;

    public HomePage() throws IOException {
    }

    public static void navigateToHomePage() throws IOException {
        driver.navigate().to(readFromGlobalPropertiesFile("webBaseUrl"));
    }

    public void clickSignIn() {
        signInButton.click();
    }

}

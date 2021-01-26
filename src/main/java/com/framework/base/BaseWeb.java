package com.framework.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseWeb {
    public static WebDriver driver;

    public BaseWeb() throws IOException {
        if(driver == null) {
            getDriver();
        }
        PageFactory.initElements(driver, this);
    }

    public static void getDriver() throws IOException {
        String browserName = readFromGlobalPropertiesFile("browser");
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                break;
        }
    }

    /**
     * Returns value of given key in Global Properties File
     * @param key
     * @return String
     * @throws IOException
     */
    public static String readFromGlobalPropertiesFile(String key) throws IOException {
        File globalPropFile = new File("src/test/resources/global.properties");
        FileInputStream stream = new FileInputStream(globalPropFile);
        Properties prop = new Properties();
        prop.load(stream);
        return prop.getProperty(key);
    }

}
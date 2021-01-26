package Utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import java.io.*;
import java.util.Properties;


public class BaseAPI {
    public static RequestSpecification reqs;

    public RequestSpecification requestSpecification() throws IOException {
        if (reqs == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            reqs = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
        }
        return reqs;
    }

    public static String getGlobalValue(String key) throws IOException {
        File propFile = new File("src/test/resources/global.properties");
        FileInputStream inputStream = new FileInputStream(propFile);
        Properties prop = new Properties();
        prop.load(inputStream);
        return prop.getProperty(key);
    }

    public String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }

    public JSONObject getJsonObject(Response response) {
        String resp = response.asString();
        JSONObject object = new JSONObject(resp);
        return object;
    }

}

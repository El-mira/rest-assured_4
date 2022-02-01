package gbtest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static org.hamcrest.Matchers.lessThan;

public class BaseTest {
    static Properties properties;
    static String host1;

    static ResponseSpecification negativeResponseSpecification;
    static RequestSpecification requestSpecification;

    @BeforeAll
    static void beforeAll() throws IOException {

        negativeResponseSpecification = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(15500l))
                .expectStatusCode(400)
                .expectStatusLine("HTTP/1.1 400 Bad Request")
                .expectBody(CoreMatchers.equalTo("Bad Request"))
                .build();

        properties = new Properties();
        properties.load(new FileInputStream("src/test/application.properties"));
        host1 = properties.getProperty("host1","https://restful-booker.herokuapp.com/");

        RestAssured.baseURI = host1;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        requestSpecification = new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .log(LogDetail.METHOD)
                .log(LogDetail.URI)
                .log(LogDetail.HEADERS)
                .log(LogDetail.COOKIES)
                .build();

        RestAssured.responseSpecification = negativeResponseSpecification;
        RestAssured.requestSpecification = requestSpecification;
    }
}

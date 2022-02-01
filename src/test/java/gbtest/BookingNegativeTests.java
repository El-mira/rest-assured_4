package gbtest;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class BookingNegativeTests extends BaseTest{
    @Test
        // пустое значение поля "firstname"
    void bookingNegative1Test() {
        given()
                .body("{\n" +
                        "    \"firstname\" : ,\n" +
                        "    \"lastname\" : \"Ноббс\",\n" +
                        "    \"totalprice\" : 155,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2022-01-25\",\n" +
                        "        \"checkout\" : \"2022-02-03\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when()
                .post("booking")
                .prettyPeek();
    }

    @Test
        // пустое значение поля "lastname"
    void bookingNegative2Test() {
        given()
                .body("{\n" +
                        "    \"firstname\" : \"Альберт\",\n" +
                        "    \"lastname\" : ,\n" +
                        "    \"totalprice\" : 155,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2022-01-25\",\n" +
                        "        \"checkout\" : \"2022-02-03\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when()
                .post("booking")
                .prettyPeek();
    }

    @Test
        // пустое значение поля "totalprice"
    void bookingNegative3Test() {
        given()
                .body("{\n" +
                        "    \"firstname\" : \"Альберт\",\n" +
                        "    \"lastname\" : \"Ноббс\",\n" +
                        "    \"totalprice\" : ,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2022-01-25\",\n" +
                        "        \"checkout\" : \"2022-02-03\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when()
                .post("booking")
                .prettyPeek();
    }

    @Test
        // пустое значение поля "firstname", "lastname"
    void bookingNegative4Test() {
        given()
                .body("{\n" +
                        "    \"firstname\" : ,\n" +
                        "    \"lastname\" : ,\n" +
                        "    \"totalprice\" : 155,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2022-01-25\",\n" +
                        "        \"checkout\" : \"2022-02-03\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when()
                .post("booking")
                .prettyPeek();
    }

    @Test
        // пустое значение поля "checkin"
    void bookingNegative5Test() {
        given()
                .body("{\n" +
                        "    \"firstname\" : \"Альберт\" ,\n" +
                        "    \"lastname\" : \"Ноббс\",\n" +
                        "    \"totalprice\" : 155,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : ,\n" +
                        "        \"checkout\" : \"2022-02-03\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when()
                .post("booking")
                .prettyPeek();
    }

    @Test
        // пустое значение поля "checkout"
    void bookingNegative6Test() {
        given()
                .body("{\n" +
                        "    \"firstname\" : \"Альберт\",\n" +
                        "    \"lastname\" : \"Ноббс\",\n" +
                        "    \"totalprice\" : 155,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2022-04-25\",\n" +
                        "        \"checkout\" : \"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : 0\n" +
                        "}")
                .when()
                .post("booking")
                .prettyPeek();
    }
}

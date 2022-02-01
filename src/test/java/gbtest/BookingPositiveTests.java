package gbtest;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class BookingPositiveTests {
// здесь я не знаю, как использовать вложенность в поле "bookingdates": "checkin", тест ругается
//     {
//    "firstname" : "Альберт",
//    "lastname" : "Ноббс",
//    "totalprice" : 155,
//    "depositpaid" : true,
//    "bookingdates" : {
//        "checkin" : "2022-01-25",
//        "checkout" : "2022-02-03"
//    },
//    "additionalneeds" : "Breakfast"
//}
//     @Test
//         // ввод валидных данных
//     void bookingPositiveDTOTest() {
//
//         MyBookingDTO myBookingDTO = new MyBookingDTO();
//         myBookingDTO.setFirst_Name("Альберт");
//         myBookingDTO.setLast_Name("Ноббс");
//         myBookingDTO.setTotalprice("365");
//         myBookingDTO.setDepositpaid("true");
//         myBookingDTO.setBookingdates();
//         myBookingDTO.setCheckin("2022-01-25");
//         myBookingDTO.setCheckout("2022-01-30");
//         myBookingDTO.setAdditionalneeds("Breakfast");
//
//         given()
//                 .header("Content-Type", "application/json")
//                 .body(myBookingDTO)
//                 .log()
//                 .method()
//                 .log()
//                 .uri()
//                 .when()
//                 .post("https://restful-booker.herokuapp.com/booking")
//                 .prettyPeek()
//                 .then()
//                 .statusCode(200)
//                 .body("booking.bookingdates.checkin", CoreMatchers.equalTo("2022-01-25"))
//                 .body("booking.firstname", CoreMatchers.equalTo("Альберт"));
//     }

    @Test
        // ввод валидных данных
    void bookingPositiveTest() {

        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"firstname\" : \"Альберт\",\n" +
                        "    \"lastname\" : \"Ноббс\",\n" +
                        "    \"totalprice\" : 155,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2022-01-25\",\n" +
                        "        \"checkout\" : \"2022-02-03\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .log()
                .method()
                .log()
                .uri()
                .when()
                .post("https://restful-booker.herokuapp.com/booking")
                .prettyPeek()
                .then()
                .statusCode(200)
                .body("booking.bookingdates.checkin", CoreMatchers.equalTo("2022-01-25"))
                .body("booking.firstname", CoreMatchers.equalTo("Альберт"));
    }

    @Test
    void getBookingTest() {
        given()
                .header("Content-Type", "application/json")
                .log()
                .method()
                .log()
                .uri()
                .expect()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
        // неправильный формат даты поля "checkin"
    void bookingNegative7Test() {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"firstname\" : \"Альберт\" ,\n" +
                        "    \"lastname\" : \"Ноббс\",\n" +
                        "    \"totalprice\" : 155,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2022-01-35\",\n" +
                        "        \"checkout\" : \"2022-02-03\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}")
                .when()
                .post("https://restful-booker.herokuapp.com/booking")
                .prettyPeek()
                .then()
                .statusCode(200)
                .body(CoreMatchers.equalTo("Invalid date"));
    }
}

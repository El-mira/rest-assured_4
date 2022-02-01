package gb;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Data
    public class MyBookingDTO {
        @JsonProperty("firstname")
        private String first_Name;

        @JsonProperty("lastname")
        private String last_Name;

        private String totalprice;
        private String depositpaid;
        private String bookingdates;
        //    private String checkin;
//    private String checkout;
        private String additionalneeds;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @lombok.Data
        public static class bookingdates {

            private String checkin;
            private String checkout;
        }
        // здесь я не знаю, как использовать вложенность в поле "bookingdates": "checkin", тест ругается
//    {
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
}

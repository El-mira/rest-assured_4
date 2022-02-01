package gb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MyAuthorizationDTO {
    @JsonProperty("username")
    private String login;

    private String password;
}

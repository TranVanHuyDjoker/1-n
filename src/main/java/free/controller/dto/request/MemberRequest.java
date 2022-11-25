package free.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {
    @NotNull
    @JsonProperty("id")
    private Long id;

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("email")
    @Email
    private String email;

    @NotNull
    @JsonProperty("phone")
    private String phone;

    @NotNull
    @JsonProperty("password")
    private String password;

}

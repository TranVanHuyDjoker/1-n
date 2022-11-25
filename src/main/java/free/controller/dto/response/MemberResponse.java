package free.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import free.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    public MemberResponse(Member m) {
        this.id = m.getId();
        this.name = m.getName();
        this.email = m.getEmail();
        this.phone = m.getPhone();
    }
}

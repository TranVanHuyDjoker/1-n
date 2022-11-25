package free.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import free.entity.NXB;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NXBResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;

    public NXBResponse(NXB nxb) {
        this.id = nxb.getId();
        this.name = nxb.getName();
        this.address = nxb.getAddress();
    }
}

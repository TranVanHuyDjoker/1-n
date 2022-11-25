package free.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import free.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("city")
   private String city;

    public AddressResponse(Address address) {
        this.id = address.getId();
        this.name = address.getName();
        this.city = address.getCity();
    }
}

package free.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    @NotNull
    @JsonProperty("id")
    private Long id;

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("number")
    private int number;

    //nxb?
}

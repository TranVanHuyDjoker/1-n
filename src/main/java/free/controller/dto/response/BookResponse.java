package free.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import free.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("number")
    private int number;

    public BookResponse(Book b) {
        this.id = b.getId();
        this.name = b.getName();
        this.number = b.getNumber();
    }
}

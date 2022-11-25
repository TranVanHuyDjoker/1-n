package free.service;

import free.controller.dto.request.BookRequest;
import free.controller.dto.response.BookResponse;

import java.util.List;

public interface BookService {
    List<BookResponse> getBook();

    void insertBook(BookRequest request, Long id);

    void updateBook(BookRequest request, Long id);

    void deleteBook(Long id);
}

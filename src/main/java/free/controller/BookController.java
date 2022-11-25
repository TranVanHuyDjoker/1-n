package free.controller;

import free.controller.dto.request.BookRequest;
import free.controller.dto.response.BookResponse;
import free.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping("/getAllBook")
    ResponseEntity<?> getAll(){
        List<BookResponse> bookResponses = service.getBook();
        return ResponseEntity.ok(bookResponses);
    }

    @PostMapping("/insertBook")
    ResponseEntity<?> insertBook(@RequestBody BookRequest request, @RequestParam Long id){
        service.insertBook(request,id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateBook")
    ResponseEntity<?> updateBook(@RequestBody BookRequest request, @RequestParam Long id){
        service.updateBook(request,id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/book/{id}")
    ResponseEntity<?> deleteBook(@PathVariable Long id){
        service.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}

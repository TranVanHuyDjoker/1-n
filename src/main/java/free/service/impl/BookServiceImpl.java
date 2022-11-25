package free.service.impl;

import free.controller.dto.request.BookRequest;
import free.controller.dto.response.BookResponse;
import free.entity.Book;
import free.entity.NXB;
import free.repository.BookRepository;
import free.repository.NXBRepository;
import free.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private NXBRepository nxbRepository;

    @Override
    public List<BookResponse> getBook() {
        return bookRepository.findAll()
                .stream()
                .map(BookResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public void insertBook(BookRequest request, Long id) {
        boolean flag = bookRepository.existsBookByName(request.getName());
        if (flag){
            throw new RuntimeException("ten da ton tai");
        }

        NXB nxb = nxbRepository.findById(id).orElseThrow(()-> new RuntimeException("k tim thay id nxb"));
        Book book = new Book();
        book.setName(request.getName());
        book.setNumber(request.getNumber());
        book.setNxb(nxb);
        bookRepository.save(book);
    }

    @Override
    public void updateBook(BookRequest request, Long id) {
        Book book = bookRepository.findById(request.getId()).orElseThrow(()->new RuntimeException("k tim thay id"));
        Set<String> names= bookRepository.findAll()
                .stream()
                .map(Book::getName)
                .collect(Collectors.toSet());
        if (names.contains(request.getName()) && !Objects.equals(request.getName(), book.getName())){
            throw new RuntimeException("names da ton tai");
        }
        NXB nxb = nxbRepository.findById(id).orElseThrow(()-> new RuntimeException("k tim thay id nxb"));
        book.setNumber(request.getNumber());
        book.setName(request.getName());
        book.setNxb(nxb);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        boolean flag= bookRepository.existsBookById(id);
        if (!flag){
            throw new RuntimeException("id k ton tai");
        }
        bookRepository.deleteById(id);
    }
}

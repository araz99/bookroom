package by.azmd.controller;

import by.azmd.dto.BookDTO;
import by.azmd.entity.Book;
import by.azmd.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    // all books
    @GetMapping
    public List<BookDTO> listAllBooks() {
        return bookService.getAllBooks();
    }

    // all free books
    @GetMapping("/free")
    public List<BookDTO> listFreeBooks() {
        return bookService.getAllFreeBooks();
    }

    // filter book by name
    @GetMapping("/name")
    public BookDTO filterByName(@RequestParam String name) {
        return bookService.getBook(name);
    }

    // filter books by author
    @GetMapping("/author")
    public List<BookDTO> filterByAuthor(@RequestParam String author) {
        return bookService.getBooksByAuthor(author);
    }
}

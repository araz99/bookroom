package by.azmd.controller;

import by.azmd.dto.BookDTO;
import by.azmd.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
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

    // universal filter
    @GetMapping("/search")
    public List<BookDTO> findBooks(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String author,
            @RequestParam(required = false, defaultValue = "") String publisher,
            @RequestParam(required = false, defaultValue = "") String yearEdition,
            @RequestParam(required = false, defaultValue = "") String translator,
            @RequestParam(required = false, defaultValue = "") String description,
            @RequestParam(required = false, defaultValue = "") String busy
    ) {
        String str = name.concat(author).concat(publisher)
                .concat(yearEdition)
                .concat(translator)
                .concat(description)
                .concat(busy);

        return str.isEmpty() ? Collections.EMPTY_LIST
                : bookService.getBooks(
                        name,
                        author,
                        publisher,
                        yearEdition,
                        translator,
                        description);
    }
}
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
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String publisher,
            @RequestParam(required = false) String yearEdition,
            @RequestParam(required = false) String translator,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String busy
    ) {
        String str = (name == null ? "" : name)
                .concat(author == null ? "" : author)
                .concat(publisher == null ? "" : publisher)
                .concat(yearEdition == null ? "" : yearEdition)
                .concat(translator == null ? "" : translator)
                .concat(description == null ? "" : description)
                .concat(busy == null ? "" : busy);
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
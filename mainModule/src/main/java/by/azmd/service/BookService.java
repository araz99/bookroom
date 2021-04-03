package by.azmd.service;

import by.azmd.dto.BookDTO;
import by.azmd.entity.Book;
import by.azmd.mapper.DtoMapper;
import by.azmd.repository.BookRepository;

import static by.azmd.specification.BookSpecification.*;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final DtoMapper<BookDTO, Book> bookMapper;

    // filter
    public List<BookDTO> getBooks(
            String name,
            String author,
            String publisher,
            String yearEdition,
            String translator,
            String description,
            String busy
    ) {
        return bookRepository.findAll(
                hasName(name)
                .and(hasAuthor(author))
                .and(hasPublisher(publisher))
                .and(hasYearEdition(yearEdition))
                .and(hasTranslator(translator))
                .and(hasDescription(description))
                .and(hasBusy(busy))
        ).stream().map(bookMapper::toDTO).collect(Collectors.toList());
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(bookMapper::toDTO).collect(Collectors.toList());
    }

    public List<BookDTO> getAllFreeBooks() {
        return bookRepository.findBooksByBusy(false).stream().map(bookMapper::toDTO).collect(Collectors.toList());
    }

    public BookDTO getBook(String name) {
        Book book = bookRepository.findByName(name);
        if (book != null)
            return bookMapper.toDTO(book);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
    }

    public List<BookDTO> getBooksByAuthor(String author) {
        List<Book> books = bookRepository.findBooksByAuthor(author);
        if (books != null)
            return books.stream().map(bookMapper::toDTO).collect(Collectors.toList());
        return new ArrayList<>();
    }

    public void save(Book book) {
        if (bookRepository.findByName(book.getName()) == null)
            bookRepository.save(book);
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book is exists!");
    }

    public void updateBusy(boolean busy, Long bookId) {
        bookRepository.updateByBusy(busy, bookId);
    }
}

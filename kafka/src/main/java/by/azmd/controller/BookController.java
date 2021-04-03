package by.azmd.controller;

import by.azmd.dto.BookDTO;
import by.azmd.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {
    private final KafkaService kafkaService;

    // add book
    @PostMapping
    public List<BookDTO> addBook(@RequestBody List<BookDTO> bookDTOList) {
        return kafkaService.send(bookDTOList);
    }
}
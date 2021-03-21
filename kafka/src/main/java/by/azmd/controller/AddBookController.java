package by.azmd.controller;

import by.azmd.dto.BookDTO;
import by.azmd.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class AddBookController {
    private final KafkaService kafkaService;

    // add book
    @PostMapping
    public BookDTO addBook(@RequestBody BookDTO bookDTO) {
        return kafkaService.send(bookDTO);
    }
}

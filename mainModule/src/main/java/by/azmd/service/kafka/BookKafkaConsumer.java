package by.azmd.service.kafka;

import by.azmd.dto.BookDTO;
import by.azmd.entity.Book;
import by.azmd.mapper.BookMapper;
import by.azmd.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookKafkaConsumer {
    private final ObjectMapper mapper;
    private final BookMapper bookMapper;
    private final BookService bookService;

    @KafkaListener(topics = "books", groupId = "group_id")
    public void bookReader(String message) throws JsonProcessingException {
        bookService.save(bookMapper.toEntity(mapper.readValue(message, BookDTO.class)));
    }
}

package by.azmd.service;

import by.azmd.dto.BookDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService {

    private final BookKafkaProducer producer;

    @SneakyThrows
    public BookDTO send(BookDTO bookDTO) {
        ObjectMapper mapper = new ObjectMapper();
        producer.sendMessage(mapper.writeValueAsString(bookDTO));
        return bookDTO;
    }
}
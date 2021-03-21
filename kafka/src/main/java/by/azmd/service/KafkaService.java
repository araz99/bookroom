package by.azmd.service;

import by.azmd.dto.BookDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.StringWriter;

@Service
@RequiredArgsConstructor
public class KafkaService {

    private final BookKafkaProducer producer;

    @SneakyThrows
    public BookDTO send(BookDTO bookDTO) {
        @Cleanup StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, bookDTO);
        producer.sendMessage(writer.toString());
        return bookDTO;
    }
}

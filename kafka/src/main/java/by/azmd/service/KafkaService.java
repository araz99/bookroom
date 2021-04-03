package by.azmd.service;

import by.azmd.dto.BookDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KafkaService {

    private final BookKafkaProducer producer;
    private final ObjectMapper mapper;

    @SneakyThrows
    public List<BookDTO> send(List<BookDTO> bookDTOList) {
        for (BookDTO bookDTO : bookDTOList)
             producer.sendMessage(mapper.writeValueAsString(bookDTO));
        return bookDTOList;
    }
}
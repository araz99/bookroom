package by.azmd.mapper;

import by.azmd.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import by.azmd.dto.BookDTO;


@Component
public class BookMapper implements DtoMapper<BookDTO, Book> {
    private final ObjectMapper mapper;
    public BookMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }
    @Override
    public BookDTO toDTO(Book entity) {
        return mapper.convertValue(entity, BookDTO.class);
    }
    @Override
    public Book toEntity(BookDTO dto) {
        return mapper.convertValue(dto, Book.class);
    }
}
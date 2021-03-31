package by.azmd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String name;
    private String author;
    private String publisher;
    private String yearEdition;
    private String translator;
    private String description;
    private boolean busy;
}
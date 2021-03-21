package by.azmd.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String author;
    @NonNull
    private String publisher;
    @NonNull
    private String yearEdition;
    @NonNull
    private String translator;
    @NonNull
    private String description;
    @NonNull
    private boolean busy;

    public boolean isEmpty() {
        if (!name.isEmpty() && !author.isEmpty() && !publisher.isEmpty() && !yearEdition.isEmpty())
            return false;
        return true;
    }
}
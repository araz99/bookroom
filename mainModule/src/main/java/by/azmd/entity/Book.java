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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "author")
    private String author;

    @NonNull
    @Column(name = "publisher")
    private String publisher;

    @NonNull
    @Column(name = "year_edition")
    private int yearEdition;

    @NonNull
    @Column(name = "translator")
    private String translator;

    @NonNull
    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "busy")
    private boolean busy;

    public boolean isEmpty() {
        if (!name.isEmpty() && !author.isEmpty() && !publisher.isEmpty())
            return false;
        return true;
    }
}
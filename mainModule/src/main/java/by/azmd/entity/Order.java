package by.azmd.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "order_book",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "book_id"})})
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    @NonNull
    private Long userId;
    @Column(name = "book_id", unique = true)
    @NonNull
    private Long bookId;
    @NonNull
    @Column(name = "order_date")
    private LocalDate orderDate;
}
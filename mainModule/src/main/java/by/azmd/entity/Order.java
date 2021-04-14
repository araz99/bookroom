package by.azmd.entity;

import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "user_id")
    private Long userId;

    @NonNull
    @Column(name = "book_id")
    private Long bookId;

    @NonNull
    @Column(name = "order_date")
    private LocalDate orderDate;
}
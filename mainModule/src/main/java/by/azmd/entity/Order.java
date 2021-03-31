package by.azmd.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;
import javax.persistence.GenerationType;
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

    @NonNull
    @Column(name = "user_id")
    private Long userId;
    @NonNull
    @Column(name = "book_id", unique = true)
    private Long bookId;
    @NonNull
    @Column(name = "order_date")
    private LocalDate orderDate;
}
package by.azmd.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_bk")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"id", "password", "quantityBook"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String username;
    @NonNull
    private String password;
    @Column(name = "quantity_book")
    private int quantityBook;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Role role;
}
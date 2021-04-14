package by.azmd.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_bk")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = {"id", "password", "quantityBook"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "username")
    private String username;

    @NonNull
    @Column(name = "password")
    private String password;

    @Column(name = "quantity_book")
    private int quantityBook;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
package by.azmd.repository;

import by.azmd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Modifying()
    @Query(value = "update user_bk ub set quantity_book = ? where ub.id= ?", nativeQuery = true)
    @Transactional
    void updateQuantityBook(int quantity, Long userId);
}
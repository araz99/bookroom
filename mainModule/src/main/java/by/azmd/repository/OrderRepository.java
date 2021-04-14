package by.azmd.repository;

import by.azmd.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderByUserIdAndBookId(Long userId, Long bookId);

    @Modifying()
    @Query(value = "update order_book ob set order_time = ? where ob.book_id = ?", nativeQuery = true)
    @Transactional
    void updateOrderTime(LocalDate orderTime, Long bookId);
}
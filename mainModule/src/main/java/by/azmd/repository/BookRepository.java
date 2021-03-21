package by.azmd.repository;

import by.azmd.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll();
    List<Book> findBooksByBusy(boolean busy);
    List<Book> findBooksByAuthor(String author);
    Book findByName(String name);

    @Modifying()
    @Query(value = "update book bk set busy = ? where bk.id = ?", nativeQuery = true)
    @Transactional
    void updateByBusy(boolean busy, Long bookId);

    List<Book> findBooksByDescription(String description);
}
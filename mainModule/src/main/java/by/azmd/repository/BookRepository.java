package by.azmd.repository;

import by.azmd.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>,
                                        JpaSpecificationExecutor<Book> {
    List<Book> findAll();
    List<Book> findBooksByBusy(boolean busy);
    List<Book> findBooksByAuthor(String author);
    Book findByName(String name);

    @Modifying()
    @Query(value = "update book bk set busy = ? where bk.id = ?", nativeQuery = true)
    @Transactional
    void updateByBusy(boolean busy, Long bookId);
}
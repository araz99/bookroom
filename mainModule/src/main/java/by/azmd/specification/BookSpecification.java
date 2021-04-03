package by.azmd.specification;

import by.azmd.entity.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    private static final String name = "name";
    private static final String author = "author";
    private static final String publisher = "publisher";
    private static final String yearEdition = "yearEdition";
    private static final String translator = "translator";
    private static final String description = "description";

    public static Specification<Book> hasName(String bookName) {
        return bookName == null ? emptySpecification()
                : (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(name), bookName);
    }

    public static Specification<Book> hasAuthor(String bookAuthor) {
        return bookAuthor == null ? emptySpecification()
                : (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(author), bookAuthor);
    }

    public static Specification<Book> hasPublisher(String bookPublisher) {
        return bookPublisher == null ? emptySpecification()
                : (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(publisher), bookPublisher);
    }

    public static Specification<Book> hasYearEdition(String bookYearEdition) {
        return bookYearEdition == null ? emptySpecification()
                : (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(yearEdition), bookYearEdition);
    }

    public static Specification<Book> hasTranslator(String bookTranslator) {
        return bookTranslator == null ? emptySpecification()
                : (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(translator), bookTranslator);
    }

    public static Specification<Book> hasDescription(String bookDescription) {
        return bookDescription == null ? emptySpecification()
                : (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(description), bookDescription);
    }

    private static Specification<Book> emptySpecification() {
        return (root, criteriaQuery, criteriaBuilder) -> null;
    }
}
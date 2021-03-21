package by.azmd.service;

import by.azmd.dto.BookDTO;
import by.azmd.dto.OrderDTO;
import by.azmd.entity.Book;
import by.azmd.entity.Order;
import by.azmd.entity.User;
import by.azmd.mapper.DtoMapper;
import by.azmd.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserService userService;
    private final BookService bookService;
    private final DtoMapper<BookDTO, Book> bookMapper;
    private final OrderRepository orderRepository;

    public OrderDTO save(OrderDTO orderDTO) {
        User user = userService.getAuthenticationUser();
        Book book = bookMapper.toEntity(bookService.getBook(orderDTO.getBookName()));
        if (!book.isEmpty()) {
            if (!book.isBusy() && user.getQuantityBook() < 5) {
                LocalDate days = LocalDate.now().plusDays(orderDTO.getQuantityDays());
                Order order = new Order(user.getId(), book.getId(), days);
                userService.updateQuantityBook(user.getQuantityBook() + 1, user.getId());
                bookService.updateBusy(true, book.getId());
                orderRepository.save(order);
            } else
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "not available");
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found!");
        return orderDTO;
    }

    public OrderDTO updateOrder(OrderDTO orderDTO) {
        User user = userService.getAuthenticationUser();
        Book book = bookMapper.toEntity(bookService.getBook(orderDTO.getBookName()));
        if (book != null) {
            Order order = orderRepository.findOrderByUserIdAndBookId(user.getId(), book.getId());
            if (order != null) {
                LocalDate days = LocalDate.now().plusDays(orderDTO.getQuantityDays());
                orderRepository.updateOrderTime(days, book.getId());
                return orderDTO;
            } else
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book is busy");
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
    }

    public void deleteOrder(String bookName) {
        User user = userService.getAuthenticationUser();
        Book book = bookMapper.toEntity(bookService.getBook(bookName));
        if (book != null) {
            Order order = orderRepository.findOrderByUserIdAndBookId(user.getId(), book.getId());
            if (order != null) {
                bookService.updateBusy(false, book.getId());
                userService.updateQuantityBook(user.getQuantityBook() - 1, user.getId());
                orderRepository.delete(order);
            } else
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found!");
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found!");
    }
}

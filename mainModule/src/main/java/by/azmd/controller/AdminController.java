package by.azmd.controller;

import by.azmd.dto.BookDTO;
import by.azmd.entity.Order;
import by.azmd.service.BookService;
import by.azmd.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final BookService bookService;
    private final OrderService orderService;

    @GetMapping("/isBusyBooks")
    public List<BookDTO> getBusyBooks() {
        return bookService.getBusyBooks();
    }

    @GetMapping("/reserves")
    public List<Order> getReserves() {
        return orderService.getAllReserves();
    }
}
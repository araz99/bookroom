package by.azmd.controller;

import by.azmd.dto.OrderDTO;
import by.azmd.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("reserves")
@RequiredArgsConstructor
public class ReserveController {

    private final OrderService orderService;

    // reservation
    @PostMapping
    public OrderDTO reservation(@RequestBody OrderDTO orderDTO) {
        return orderService.save(orderDTO);
    }

    // extension of reserve
    @PutMapping("/extension")
    public OrderDTO extension(@RequestBody OrderDTO orderDTO) {
        return orderService.updateOrder(orderDTO);
    }

    // cancelling reserve
    @DeleteMapping("{bookName}")
    public void canceling(@PathVariable String bookName) {
        orderService.deleteOrder(bookName);
    }
}
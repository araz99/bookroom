package by.azmd.mapper;

import by.azmd.dto.OrderDTO;
import by.azmd.entity.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class OrderMapper implements DtoMapper<OrderDTO, Order>{
    private final ObjectMapper mapper;

    public OrderMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }
    @Override
    public OrderDTO toDTO(Order entity) {
        OrderDTO orderDTO = mapper.convertValue(entity, OrderDTO.class);
        LocalDate orderDate = entity.getOrderDate();
        long days = ChronoUnit.DAYS.between(LocalDate.now(), orderDate);
        orderDTO.setQuantityDays((int) days);
        return orderDTO;
    }
    @Override
    public Order toEntity(OrderDTO dto) {
        Order order = mapper.convertValue(dto, Order.class);
        LocalDate date = LocalDate.now().plusDays(dto.getQuantityDays());
        order.setOrderDate(date);
        return order;
    }
}
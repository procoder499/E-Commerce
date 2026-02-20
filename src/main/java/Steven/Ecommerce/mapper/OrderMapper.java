package Steven.Ecommerce.mapper;

import Steven.Ecommerce.dto.order.OrderItemResponse;
import Steven.Ecommerce.dto.order.OrderResponse;
import Steven.Ecommerce.entity.Order;
import Steven.Ecommerce.entity.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class OrderMapper {


    public  OrderResponse toResponse(Order order) {
        if (order == null) return null;


        OrderResponse dto = new OrderResponse();
        dto.setId(order.getId());
        dto.setStatus(order.getStatus().name());
        dto.setTotalPrice(order.getTotalPrice().doubleValue());


        List<OrderItemResponse> items = order.getItems().stream()
                .map(OrderMapper::toItemResponse)
                .collect(Collectors.toList());


        dto.setItems(items);
        return dto;
    }

    private static OrderItemResponse toItemResponse(OrderItem item) {
        OrderItemResponse dto = new OrderItemResponse();
        dto.setProductName(item.getProduct().getName());
        dto.setQuantity(item.getQuantity());
        dto.setPrice(item.getPrice().doubleValue());
        return dto;
    }
}

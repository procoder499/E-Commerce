package Steven.Ecommerce.service;

import Steven.Ecommerce.dto.order.OrderRequest;
import Steven.Ecommerce.dto.order.OrderResponse;
import Steven.Ecommerce.enums.OrderStatus;

import java.util.List;

public interface OrderService {

    List<OrderResponse> getAllOrders();

    OrderResponse getOrderById(Long id);

    OrderResponse createOrder(String email, OrderRequest request);

    void updateStatus(Long orderId, OrderStatus status);

    List<OrderResponse> getOrdersByUser(String email);
}


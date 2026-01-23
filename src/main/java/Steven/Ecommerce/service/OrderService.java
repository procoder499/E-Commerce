package Steven.Ecommerce.service;

import Steven.Ecommerce.dto.order.OrderItemRequest;
import Steven.Ecommerce.dto.order.OrderRequest;
import Steven.Ecommerce.dto.order.OrderResponse;
import Steven.Ecommerce.entity.Order;
import Steven.Ecommerce.entity.OrderItem;
import Steven.Ecommerce.entity.Product;
import Steven.Ecommerce.entity.User;
import Steven.Ecommerce.enums.OrderStatus;
import Steven.Ecommerce.enums.PaymentStatus;
import Steven.Ecommerce.mapper.OrderMapper;
import Steven.Ecommerce.repository.OrderRepository;
import Steven.Ecommerce.repository.ProductRepository;
import Steven.Ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;


    public OrderResponse createOrder(Long userId, OrderRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));


        Order order = new Order();
        order.setUser(user);
        order.setStatus(OrderStatus.PENDING);
        order.setPaymentStatus(PaymentStatus.UNPAID);


        List<OrderItem> items = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;


        for (OrderItemRequest itemRequest : request.getItems()) {
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));


            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(itemRequest.getQuantity());
            item.setPrice(product.getPrice());
            item.setOrder(order);


            total = total.add(product.getPrice()
                    .multiply(BigDecimal.valueOf(itemRequest.getQuantity())));


            items.add(item);
        }


        order.setItems(items);
        order.setTotalPrice(total);


        return OrderMapper.toResponse(orderRepository.save(order));
    }
}


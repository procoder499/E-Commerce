package Steven.Ecommerce.controller;

import Steven.Ecommerce.dto.order.OrderRequest;
import Steven.Ecommerce.dto.order.OrderResponse;
import Steven.Ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderResponse create(@RequestBody OrderRequest request,
                                Authentication authentication) {

        String email = authentication.getName();
        return orderService.createOrder(email, request);
    }

    @GetMapping("/my")
    public List<OrderResponse> myOrders(@RequestParam Long userId,
                                        Authentication authentication) {
        String email = authentication.getName();
        return orderService.getOrdersByUser(email);
    }
}

package Steven.Ecommerce.controller;

import Steven.Ecommerce.dto.order.OrderResponse;
import Steven.Ecommerce.enums.OrderStatus;
import Steven.Ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/orders")
@RequiredArgsConstructor
public class AdminOrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderResponse> getAll(){
        return orderService.getAllOrders();
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam OrderStatus status){
        orderService.updateStatus(id ,status);
    }
}

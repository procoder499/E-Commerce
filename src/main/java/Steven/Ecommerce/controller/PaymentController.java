package Steven.Ecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymenetService;

    @PostMapping("/{orderId}")
    public void pay(@PathVariable Long orderId){
        paymentService.pay(orderId);
    }

    @GetMapping("/{orderId}")
    public String status(@PathVariable Long orderId){
        return paymentService.getStatus(orderId);
    }
}

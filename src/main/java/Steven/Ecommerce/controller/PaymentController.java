package Steven.Ecommerce.controller;

import Steven.Ecommerce.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/{orderId}")
    public void pay(@PathVariable Long orderId){
        paymentService.pay(orderId);
    }

    @GetMapping("/{orderId}")
    public String status(@PathVariable Long orderId){
        return paymentService.getStatus(orderId);
    }
}

package Steven.Ecommerce.service.impl;

import Steven.Ecommerce.service.PaymentService;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public void pay(Long orderId){
        System.out.println("Paying order " + orderId);
    }

    @Override
    public String getStatus(Long orderId){
        return "PAID";
    }
}

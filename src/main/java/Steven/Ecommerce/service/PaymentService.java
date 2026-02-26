package Steven.Ecommerce.service;

public interface PaymentService {
    void pay(Long oderId);

    String getStatus(Long orderId);
}

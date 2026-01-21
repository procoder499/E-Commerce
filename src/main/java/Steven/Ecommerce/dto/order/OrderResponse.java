package Steven.Ecommerce.dto.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    private String status;
    private Double totalPrice;
    private List<OrderItemResponse> items;
}

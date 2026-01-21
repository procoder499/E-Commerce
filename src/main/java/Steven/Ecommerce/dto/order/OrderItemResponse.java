package Steven.Ecommerce.dto.order;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemResponse {
    private String productName;
    private Integer quantity;
    private Double price;
}

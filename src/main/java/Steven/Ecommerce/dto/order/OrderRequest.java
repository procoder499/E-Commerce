package Steven.Ecommerce.dto.order;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class OrderRequest {
    @NotEmpty
    @Valid
    private List<OrderItemRequest> items;
}

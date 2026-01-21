package Steven.Ecommerce.mapper;

import Steven.Ecommerce.dto.product.ProductResponse;
import Steven.Ecommerce.entity.Product;

public class ProductMapper {
    public static ProductResponse toResponse(Product product){
        if(product == null) return null;

        ProductResponse dto = new ProductResponse();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        dto.setCategoryName(product.getCategory().getName());
        return dto;
    }
}

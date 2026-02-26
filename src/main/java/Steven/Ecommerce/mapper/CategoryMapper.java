package Steven.Ecommerce.mapper;

import Steven.Ecommerce.dto.category.CategoryResponse;
import Steven.Ecommerce.entity.Category;

public class CategoryMapper {
    public CategoryResponse toResponse(Category category){
        if(category == null) return null;

        CategoryResponse dto = new CategoryResponse();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }
}

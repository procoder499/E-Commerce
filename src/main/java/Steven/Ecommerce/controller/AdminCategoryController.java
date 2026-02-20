package Steven.Ecommerce.controller;

import Steven.Ecommerce.dto.category.CategoryRequest;
import Steven.Ecommerce.dto.category.CategoryResponse;
import Steven.Ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/categories")
@RequiredArgsConstructor
public class AdminCategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryResponse create(@RequestBody CategoryRequest request){
        return categoryService.create(request);
    }

    @PutMapping("/{id")
    public CategoryResponse update(@PathVariable Long id, @RequestBody CategoryRequest request){
        return categoryService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }
}

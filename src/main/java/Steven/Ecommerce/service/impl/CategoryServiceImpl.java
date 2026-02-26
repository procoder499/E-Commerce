package Steven.Ecommerce.service.impl;

import Steven.Ecommerce.dto.category.CategoryRequest;
import Steven.Ecommerce.dto.category.CategoryResponse;
import Steven.Ecommerce.entity.Category;
import Steven.Ecommerce.mapper.CategoryMapper;
import Steven.Ecommerce.repository.CategoryRepository;
import Steven.Ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public CategoryResponse create(CategoryRequest request){
        Category category = new Category();
        category.setName(request.getName());

        Category savedCategory = categoryRepository.save(category);

        return categoryMapper.toResponse(savedCategory);
    }

    @Override
    public CategoryResponse update(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(request.getName());

        return categoryMapper.toResponse(
                categoryRepository.save(category)
        );
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        categoryRepository.delete(category);
    }
    @Override
    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }
}
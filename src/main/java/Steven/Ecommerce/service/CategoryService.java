package Steven.Ecommerce.service;

import Steven.Ecommerce.dto.category.CategoryRequest;
import Steven.Ecommerce.dto.category.CategoryResponse;
import Steven.Ecommerce.entity.Category;
import Steven.Ecommerce.mapper.CategoryMapper;
import Steven.Ecommerce.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryResponse create(CategoryRequest request){
        if(categoryRepository.existsByName(request.getName())){
            throw new RuntimeException("Category already exists");
        }

        Category category = new Category();
        category.setName(request.getName());
        return CategoryMapper.toResponse(categoryRepository.save(category));
    }

    public List<CategoryResponse> getAll(){
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toResponse)
                .collect(Collectors.toList());
    }
}

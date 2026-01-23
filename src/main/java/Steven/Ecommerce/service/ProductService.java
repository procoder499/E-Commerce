package Steven.Ecommerce.service;


import Steven.Ecommerce.dto.product.ProductRequest;
import Steven.Ecommerce.dto.product.ProductResponse;
import Steven.Ecommerce.entity.Category;
import Steven.Ecommerce.entity.Product;
import Steven.Ecommerce.mapper.ProductMapper;
import Steven.Ecommerce.repository.CategoryRepository;
import Steven.Ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public ProductResponse create(ProductRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));


        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setCategory(category);


        return ProductMapper.toResponse(productRepository.save(product));
    }


    public List<ProductResponse> getAll() {
        return productRepository.findByActiveTrue()
                .stream()
                .map(ProductMapper::toResponse)
                .collect(Collectors.toList());
    }
}
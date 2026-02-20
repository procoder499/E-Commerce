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

//@Service
//@RequiredArgsConstructor
public interface ProductService {

    List<ProductResponse> getAll();

    ProductResponse getById(Long id);

    ProductResponse create(ProductRequest request);

    ProductResponse update(Long id, ProductRequest request);

    void delete(Long id);
}

package com.svetlin.store.product.service;

import com.svetlin.store.product.dto.ProductDto;
import com.svetlin.store.product.exception.BadRequestException;
import com.svetlin.store.product.model.Product;
import com.svetlin.store.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ProductDto getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(
                        () -> new BadRequestException(String.format("Product with id %d not found", id)));

        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepository.findAll();

        return productList
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        Product productSaved = productRepository.save(product);

        return modelMapper.map(productSaved, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        if (productDto.getId() == null) {
            throw new RuntimeException("The id must not be null");
        }
        Optional<Product> maybeProduct = productRepository.findById(productDto.getId());
        if (maybeProduct.isPresent()) {
            Product product = modelMapper.map(productDto, Product.class);
            Product productSaved = productRepository.save(product);
            return modelMapper.map(productSaved, ProductDto.class);
        }
        throw new RuntimeException("Product already exists");
    }
}

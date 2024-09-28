package com.example.product.service;

import com.example.product.Command;
import com.example.product.IProductRepository;
import com.example.product.model.Product;
import com.example.product.model.ProductDto;
import com.example.product.model.UpdateProductDto;
import com.example.product.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductDto, ProductDto> {
    private final IProductRepository iProductRepository;

    public UpdateProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    public ProductDto execute(UpdateProductDto input) {
        Product product = iProductRepository.findById(input.getId())
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + input.getId() + " not found"));

        updateProductDetails(product, input.getProductDto());
        return new ProductDto(iProductRepository.save(product));
    }

    private void updateProductDetails(Product product, ProductDto productDto) {
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
    }
}

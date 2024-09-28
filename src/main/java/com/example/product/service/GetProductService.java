package com.example.product.service;

import com.example.product.IProductRepository;
import com.example.product.Query;
import com.example.product.exception.ProductNotFoundException;
import com.example.product.model.Product;
import com.example.product.model.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductService implements Query<Integer, ProductDto> {
    private final IProductRepository iProductRepository;

    public GetProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    public ResponseEntity<ProductDto> execute(Integer id) {
        Product product = iProductRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));

        return ResponseEntity.status(HttpStatus.OK).body(new ProductDto(product));
    }
}

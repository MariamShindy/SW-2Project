package com.productService.services;

import com.productService.dto.ProductRequest;
import com.productService.dto.ProductResponse;
import com.productService.model.Product;
import com.productService.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    private static final Logger logger = Logger.getLogger(ProductService.class.getName());


    @Transactional
    public void createProduct(ProductRequest productRequest) {
        Product product = mapProductRequestToProduct(productRequest);
        productRepository.save(product);
        logger.info("Product created successfully");
    }

    @Transactional
    public List<ProductResponse> getAllProducts() {
        logger.info("Getting all products");
        List<Product> products = productRepository.findAll();
        return products.stream().map(this:: mapproductToProductResponse).collect(Collectors.toList());
    }

    public ProductResponse getProductById(int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
        return mapproductToProductResponse(product);
    }

    public void deleteProduct(int id){
        productRepository.deleteById(id);
        logger.info("Product with id"+ id +"deleted successfully");
    }

    public ResponseEntity<Product> updateProduct(int id , ProductRequest productRequest){
        Product product = new Product();
        product.setDescription(productRequest.getDescription());
        product.setImage(productRequest.getImage());
        product.setPrice(productRequest.getPrice());
        product.setAvailableQuantity(productRequest.getAvailableQuantity());
        product.setName(productRequest.getName());
        return ResponseEntity.ok(product);
    }

    //Product ==> ProductResponse
    private ProductResponse mapproductToProductResponse(Product product){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice((product.getPrice()));
        productResponse.setAvailableQuantity(product.getAvailableQuantity());
        productResponse.setImage(product.getImage());
        return productResponse;
    }

    //ProductRequest ==> Product
    private Product mapProductRequestToProduct(ProductRequest productRequest){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice((productRequest.getPrice()));
        product.setAvailableQuantity(productRequest.getAvailableQuantity());
        product.setImage(productRequest.getImage());
        return product;
    }

}

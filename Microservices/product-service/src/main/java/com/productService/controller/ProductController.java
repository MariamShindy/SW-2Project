package com.productService.controller;

import com.productService.dto.ProductRequest;
import com.productService.dto.ProductResponse;
import com.productService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value = "/createProduct", method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
    @PostMapping("/createProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
         productService.createProduct(productRequest);
    }
    @GetMapping ("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/api/products/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable int id) {
        ProductResponse productResponse = productService.getProductById(id);
        return ResponseEntity.ok(productResponse);
    }
    @DeleteMapping("/api/products/deleteProduct/{id}")
        public void deleteProductById (@PathVariable int id){
            productService.deleteProduct(id);
    }

    @PutMapping("/api/products/updateProduct/{id}")
    public void updateProductById(@PathVariable int id , @RequestBody ProductRequest productRequest){
        productService.updateProduct(id , productRequest);
    }
    /*
    @PostMapping("/addToCart/{userId}")
public ResponseEntity<String> addToCart(@PathVariable int userId , @RequestBody ProductRequest productRequest){
    ResponseEntity<String> response = restTemplate.postForEntity("http://cart-service/addToCart", productRequest, String.class);
    return response;
}

@PostMapping("/addToWishlist/{userId}")
public ResponseEntity<String> addToWishlist(@PathVariable int userId , @RequestBody ProductRequest productRequest){
    ResponseEntity<String> response = restTemplate.postForEntity("http://wishlist-service/addItemToWishlist", productRequest, String.class);
    return response;
}

    */
    @PostMapping("/addToCart/{userId}")
    public ResponseEntity<String> addToCart(@PathVariable int userId , @RequestBody ProductRequest productRequest){
        ResponseEntity<String> response = restTemplate.postForEntity("http://cart-service/api/cart/addToCart",productRequest,String.class);
        return response;
    }
    @PostMapping("/addToWishlist/{userId}")
    public ResponseEntity<String> addToWishlist(@PathVariable int userId , @RequestBody ProductRequest productRequest){
        ResponseEntity<String> response = restTemplate.postForEntity("http://wishlist-service/api/wishlist/addItemToWishlist",productRequest,String.class);
        return response;
    }
}

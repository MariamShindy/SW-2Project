package com.orderService.controller;

import com.orderService.dto.OrderRequest;
import com.orderService.model.Order;
import com.orderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private  OrderService orderService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest , Principal principal){
        if (principal != null) {
            int userId = Integer.parseInt(principal.getName());
            orderRequest.setUserId(userId);
        } else {
            // If there's no authenticated user, set a default user ID
            orderRequest.setUserId(1);
        }
        orderService.placeOrder(orderRequest);
        //restTemplate.delete("http://cart-service/api/cart/removeItemsFromCartToOrder/{userId}", orderRequest.getUserId());
        //restTemplate.delete("http://localhost:9091/api/cart/removeItemsFromCartToOrder/{userId}", orderRequest.getUserId());
        return "Order Placed Successfully";
    }
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok().body(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable long orderId) {
        Optional<Order> order = orderService.getOrderById(orderId);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable int userId) {
        List<Order> orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok().body(orders);
    }

}

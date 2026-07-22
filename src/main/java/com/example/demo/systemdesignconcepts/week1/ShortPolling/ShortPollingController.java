package com.example.demo.systemdesignconcepts.week1.ShortPolling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/short/orders")
public class ShortPollingController {
    @Autowired
    OrderService orderService;

    @GetMapping("/{id}/status")
    public OrderStatus getStatus(@PathVariable String id){
        return orderService.getStatus(id);
    }

    @PostMapping("/{id}/status")
    public void update (@PathVariable String id, @RequestBody String status){
        orderService.update(new OrderStatus(id, status));
    }
}

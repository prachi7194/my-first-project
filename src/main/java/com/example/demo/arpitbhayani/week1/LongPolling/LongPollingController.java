package com.example.demo.arpitbhayani.week1.LongPolling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/long/orders")
public class LongPollingController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{id}/status")
    public DeferredResult<OrderStatus> getStatus(@PathVariable String id){
        return orderService.waitForUpdate(id);
    }

    @PostMapping("/{id}/status")
    public void update (@PathVariable String id, @RequestBody String status){
        orderService.updateOrder(id, status);
    }


}

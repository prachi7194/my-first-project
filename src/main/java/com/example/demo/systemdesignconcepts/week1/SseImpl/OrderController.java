package com.example.demo.systemdesignconcepts.week1.SseImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/{id}/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter stream(@PathVariable String id){
        return orderService.subscribe(id);
    }

    @PostMapping("{id}/status")
    public void update(@PathVariable String id, @RequestBody String status){
        orderService.publish(new OrderStatus(id, status));
    }

}

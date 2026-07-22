package com.example.demo.systemdesignconcepts.week1.LongPolling;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class OrderStatus {
    private String orderId;
    private String status;
}

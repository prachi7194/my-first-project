package com.example.demo.systemdesignconcepts.week1.ShortPolling;

import lombok.*;


@Data
@AllArgsConstructor
public class OrderStatus {
    private String orderId;
    private String status;
}

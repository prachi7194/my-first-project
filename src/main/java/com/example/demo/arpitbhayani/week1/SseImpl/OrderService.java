package com.example.demo.arpitbhayani.week1.SseImpl;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class OrderService {

    private final Map<String, List<SseEmitter>> emitters = new ConcurrentHashMap<>();

    public SseEmitter subscribe(String orderId) {

        SseEmitter emitter = new SseEmitter(0L);

        emitters.computeIfAbsent(orderId,
                        id -> new CopyOnWriteArrayList<>())
                .add(emitter);

        emitter.onCompletion(() ->
                emitters.get(orderId).remove(emitter));

        emitter.onTimeout(() ->
                emitters.get(orderId).remove(emitter));

        emitter.onError(e ->
                emitters.get(orderId).remove(emitter));

        return emitter;
    }

    public void publish(OrderStatus status) {

        List<SseEmitter> list = emitters.get(status.getOrderId());

        if (list == null)
            return;

        for (SseEmitter emitter : list) {

            try {

                emitter.send(
                        SseEmitter.event()
                                .name("order-update")
                                .data(status)
                );

            } catch (Exception ex) {

                emitter.complete();

            }

        }

    }

}

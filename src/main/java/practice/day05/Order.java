package practice.day05;

import java.time.LocalDateTime;

public class Order {

    private String orderId;
    private String customerId;
    private double amount;
    private OrderStatus status;
    private LocalDateTime orderTime;

    enum OrderStatus {
        CREATED,
        PAID,
        CANCELLED
    }
}

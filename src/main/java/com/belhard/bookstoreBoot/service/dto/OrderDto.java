package com.belhard.bookstoreBoot.service.dto;

import com.belhard.bookstoreBoot.data.entity.Order;
import com.belhard.bookstoreBoot.data.entity.OrderInfo;
import com.belhard.bookstoreBoot.data.entity.User;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDto {

    private Long id;
    private User user;
    private BigDecimal totalCost;
    private Order.Status status;
    private List<OrderInfo> details;

    public enum Status{
        PENDING,PAID,DELIVERED,CANCELED
    }
}

package com.belhard.bookstoreBoot.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "order_bh")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @Column(name = "status")
    private Status status;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderInfo> details;

    public enum Status{
        PENDING,PAID,DELIVERED,CANCELED
    }
}

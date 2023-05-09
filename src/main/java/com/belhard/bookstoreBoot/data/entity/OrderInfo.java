package com.belhard.bookstoreBoot.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "order_info")
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "book_quantity")
    private Integer bookQuantity;

    @Column(name = "book_price")
    private BigDecimal bookPrice;
}

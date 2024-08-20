package com.samsung.finaljava2.repository.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user_id;
    private Integer total_qty;
    private Long total_amount;
    private Boolean status;

    @OneToMany
    @JoinColumn(name="order_id")
    private List<OrderDetail> orderDetails;
}

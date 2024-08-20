package com.samsung.finaljava2.repository.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150)
    private String name;

    @Column(length = 200)
    private String picture;

    private Long price;

    @OneToMany
    @JoinColumn(name="product_id")
    private List<Cart> carts;
}

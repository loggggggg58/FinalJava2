package com.samsung.finaljava2.repository.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false, unique = true)
    private String username;

    @Column(length = 200, nullable = false)
    private String password;


    @Column(length = 150)
    private String email;

    @Column(length = 150)
    private String fullName;

    private Boolean status;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<Order> orders;
}

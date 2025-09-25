package com.tech_store.Domain.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "supplier")
@Getter
@Setter
@NoArgsConstructor
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category", nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
    private String name;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;


}

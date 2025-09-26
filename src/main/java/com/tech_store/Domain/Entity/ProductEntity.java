package com.tech_store.Domain.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tech_store_products")
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id;

    @Column(nullable = false, length =40, unique = true)
    private String name;

    @Column(nullable = false, length =100)
    private String description;

    @Column(nullable = false, columnDefinition = "DOUBLE PRECISION")
    private Double price;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private Boolean available;

    @Column(name = "created_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime CreatedDate;

    //relaciones
    @ManyToOne
    @JoinColumn(name= "id_category", referencedColumnName = "category_id", insertable = false, updatable = false)
    private CategoryEntity category;

    @ManyToMany
    @JoinTable(
            name = "products_suppliers",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_supplier")
    )
    private Set<SupplierEntity> suppliers = new HashSet<>();

}

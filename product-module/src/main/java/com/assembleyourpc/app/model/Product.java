package com.assembleyourpc.app.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tblProduct")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(unique = true, name = "productTitle", updatable = true, length = 100)
    private String productTitle;

    @Column(nullable = false, name = "productName",length = 50)
    private String productName;

    @Column(name = "productDesc", nullable = true, length = 500)
    private String productDesc;

    @Column(name = "productPricePerUnit",nullable = false)
    private Double productPricePerUnit;

    @Column(name = "productCreationDT", nullable = false)
    private LocalDateTime productCreationDT;

    @Column(name = "productLastUpdateDT", nullable = false)
    private LocalDateTime productLastUpdateDT;

    @ManyToOne
    @JoinColumn(name = "brandId", nullable = false)
    @JsonBackReference
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    @JsonBackReference
    private Category category;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "stockId", nullable = false)
    @JsonBackReference
    private Stock stock;

}

package com.assembleyourpc.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblBrand")
public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;

    @Column(name = "brandName", nullable = false, unique = true)
    private String brandName;

    @Column(name = "brandDesc")
    private String brandDesc;

    @Column(name= "brandCreationDT")
    private LocalDateTime brandCreationDT;

    @OneToMany(mappedBy = "brand",fetch = FetchType.LAZY)
    @JsonBackReference
    Set<Product> products;

}

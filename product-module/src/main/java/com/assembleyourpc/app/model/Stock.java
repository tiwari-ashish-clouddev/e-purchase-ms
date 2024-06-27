package com.assembleyourpc.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tblStock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;

    @OneToOne(mappedBy = "stock",fetch = FetchType.EAGER)
    @JoinColumn(name = "productId", nullable = false)
    @JsonBackReference
    private Product product;

    @Column(name = "productQuantity", nullable = false)
    private Integer productQuantity;

    @Column(name = "stockCreationDT", nullable = false)
    private LocalDateTime stockCreationDT;
}

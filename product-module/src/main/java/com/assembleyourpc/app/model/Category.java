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
@Table(name = "tblCategory")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(nullable = false, name = "categoryName",length = 25)
    private String categoryName;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Product> products;

    @Column(name = "categoryCreationDT", nullable = false)
    private LocalDateTime categoryCreationDT;

}

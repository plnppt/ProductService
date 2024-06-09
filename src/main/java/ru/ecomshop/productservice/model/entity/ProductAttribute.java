package ru.ecomshop.productservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "product_attributes")
public class ProductAttribute {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_attributes_sequence"
    )
    @SequenceGenerator(
            name = "product_attributes_sequence",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String attributeName;

    private String attributeValue;
}
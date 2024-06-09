package ru.ecomshop.productservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "brands_sequence"
    )
    @SequenceGenerator(
            name = "brands_sequence",
            allocationSize = 1
    )
    private Long id;

    private String name;

    private String description;
}
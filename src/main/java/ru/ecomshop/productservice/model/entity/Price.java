package ru.ecomshop.productservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "prices_sequence"
    )
    @SequenceGenerator(
            name = "prices_sequence",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private double price;

    @Enumerated(EnumType.STRING)
    private PriceType priceType;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;
}


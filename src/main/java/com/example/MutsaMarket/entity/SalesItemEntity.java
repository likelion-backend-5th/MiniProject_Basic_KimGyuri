package com.example.MutsaMarket.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sales_item")
public class SalesItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="min_price_wanted")
    private Long minPriceWanted;

    private String status;
    private String writer;
    private String password;
}

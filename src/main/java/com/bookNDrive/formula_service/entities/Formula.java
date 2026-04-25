package com.bookNDrive.formula_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "formula")
public class Formula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;
    private boolean code;
    private Double promotionnalPrice;

    Formula(String title, String description, double price, boolean code) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.code = code;
    }

}

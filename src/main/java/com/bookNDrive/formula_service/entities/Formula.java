package com.bookNDrive.formula_service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "formulas")
public class Formula extends BaseEntity {


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

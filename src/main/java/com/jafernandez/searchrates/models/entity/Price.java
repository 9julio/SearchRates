package com.jafernandez.searchrates.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "prices")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Price {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private int price_id;

    @Column
    private int brand_id;

    @Column
    private Timestamp start_date;

    @Column
    private Timestamp end_date;

    @Column
    private String price_list;

    @Column
    private int product_id;

    @Column
    private int priority;

    @Column
    private double price;

    @Column
    private String currency;

    @Column
    private Timestamp last_update;

    @Column
    private String last_update_by;

}

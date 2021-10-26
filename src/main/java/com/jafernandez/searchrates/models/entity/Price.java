package com.jafernandez.searchrates.models.entity;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "prices")
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

    public Price() { }

    public Price(int price_id, int brand_id, Timestamp start_date, Timestamp end_date, String price_list, int product_id, int priority, double price, String currency, Timestamp last_update, String last_update_by) {
        this.price_id = price_id;
        this.brand_id = brand_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.price_list = price_list;
        this.product_id = product_id;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
        this.last_update = last_update;
        this.last_update_by = last_update_by;
    }

    public int getPrice_id() {
        return price_id;
    }

    public void setPrice_id(int price_id) {
        this.price_id = price_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }

    public String getPrice_list() {
        return price_list;
    }

    public void setPrice_list(String price_list) {
        this.price_list = price_list;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    public String getLast_update_by() {
        return last_update_by;
    }

    public void setLast_update_by(String last_update_by) {
        this.last_update_by = last_update_by;
    }

}

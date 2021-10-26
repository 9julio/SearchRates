package com.jafernandez.searchrates.models.dto;

import java.util.Objects;

public class Price {

    private int productId;
    private int brandId;
    private String priceList;
    private String date;
    private double price;
    private String currency;

    public Price() { }

    public Price(int productId, int brandId, String priceList, String date, double price, String currency) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.date = date;
        this.price = price;
        this.currency = currency;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getPriceList() {
        return priceList;
    }

    public void setPriceList(String priceList) {
        this.priceList = priceList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price prices = (Price) o;
        return productId == prices.productId && brandId == prices.brandId && Double.compare(prices.price, price) == 0 && Objects.equals(priceList, prices.priceList) && Objects.equals(date, prices.date) && Objects.equals(currency, prices.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, brandId, priceList, date, price, currency);
    }

    @Override
    public String toString() {
        return "Price{" +
                "productId=" + productId +
                ", brandId=" + brandId +
                ", priceList='" + priceList + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }

}

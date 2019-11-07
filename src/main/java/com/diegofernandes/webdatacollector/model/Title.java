package com.diegofernandes.webdatacollector.model;

import java.util.Objects;

public class Title {

    private String title;
    private String expiry;
    private String yieldRate;
    private String unitPrice;

    public Title() {
    }

    public Title(String title, String expiry, String yieldRate, String unitPrice) {
        this.title = title;
        this.expiry = expiry;
        this.yieldRate = yieldRate;
        this.unitPrice = unitPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getYieldRate() {
        return yieldRate;
    }

    public void setYieldRate(String yieldRate) {
        this.yieldRate = yieldRate;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Title)) return false;
        Title title1 = (Title) o;
        return Objects.equals(getTitle(), title1.getTitle()) &&
                Objects.equals(getExpiry(), title1.getExpiry()) &&
                Objects.equals(getYieldRate(), title1.getYieldRate()) &&
                Objects.equals(getUnitPrice(), title1.getUnitPrice());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTitle(), getExpiry(), getYieldRate(), getUnitPrice());
    }

    @Override
    public String toString() {
        return "Title{" +
                "title='" + title + '\'' +
                ", expiry='" + expiry + '\'' +
                ", yieldRate='" + yieldRate + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}

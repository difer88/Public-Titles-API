package com.diegofernandes.publictitlesapi.model;

import java.util.Objects;

public class TitleDTO {

    private Integer id;
    private String name;
    private String dueDate;
    private String quoteTime;
    private Double ratePurchase;
    private Double rateSale;
    private Double unityValuePurchase;
    private Double unityValueSale;

    public TitleDTO() {
    }

    public TitleDTO(Integer id, String name, String dueDate, String quoteTime, Double ratePurchase, Double rateSale, Double unityValuePurchase, Double unityValueSale) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
        this.quoteTime = quoteTime;
        this.ratePurchase = ratePurchase;
        this.rateSale = rateSale;
        this.unityValuePurchase = unityValuePurchase;
        this.unityValueSale = unityValueSale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getQuoteTime() {
        return quoteTime;
    }

    public void setQuoteTime(String quoteTime) {
        this.quoteTime = quoteTime;
    }

    public Double getRatePurchase() {
        return ratePurchase;
    }

    public void setRatePurchase(Double ratePurchase) {
        this.ratePurchase = ratePurchase;
    }

    public Double getRateSale() {
        return rateSale;
    }

    public void setRateSale(Double rateSale) {
        this.rateSale = rateSale;
    }

    public Double getUnityValuePurchase() {
        return unityValuePurchase;
    }

    public void setUnityValuePurchase(Double unityValuePurchase) {
        this.unityValuePurchase = unityValuePurchase;
    }

    public Double getUnityValueSale() {
        return unityValueSale;
    }

    public void setUnityValueSale(Double unityValueSale) {
        this.unityValueSale = unityValueSale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TitleDTO)) return false;
        TitleDTO titleDTO = (TitleDTO) o;
        return Objects.equals(getId(), titleDTO.getId()) &&
                Objects.equals(getName(), titleDTO.getName()) &&
                Objects.equals(getDueDate(), titleDTO.getDueDate()) &&
                Objects.equals(getQuoteTime(), titleDTO.getQuoteTime()) &&
                Objects.equals(getRatePurchase(), titleDTO.getRatePurchase()) &&
                Objects.equals(getRateSale(), titleDTO.getRateSale()) &&
                Objects.equals(getUnityValuePurchase(), titleDTO.getUnityValuePurchase()) &&
                Objects.equals(getUnityValueSale(), titleDTO.getUnityValueSale());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getDueDate(), getQuoteTime(), getRatePurchase(), getRateSale(), getUnityValuePurchase(), getUnityValueSale());
    }

    @Override
    public String toString() {
        return "TitleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", quoteTime='" + quoteTime + '\'' +
                ", ratePurchase=" + ratePurchase +
                ", rateSale=" + rateSale +
                ", unityValuePurchase=" + unityValuePurchase +
                ", unityValueSale=" + unityValueSale +
                '}';
    }
}

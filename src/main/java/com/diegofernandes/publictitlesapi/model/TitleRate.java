package com.diegofernandes.publictitlesapi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "titles_rate_tbl")
public class TitleRate {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int rateId;

    @Column
    private int titleId;
    @Column
    private String quoteTime;
    @Column
    private Double ratePurchase;
    @Column
    private Double rateSale;
    @Column
    private Double unityValuePurchase;
    @Column
    private Double unityValueSale;

    public TitleRate() {
    }

    public TitleRate(int titleId, String quoteTime, Double ratePurchase, Double rateSale, Double unityValuePurchase, Double unityValueSale) {
        this.titleId = titleId;
        this.quoteTime = quoteTime;
        this.ratePurchase = ratePurchase;
        this.rateSale = rateSale;
        this.unityValuePurchase = unityValuePurchase;
        this.unityValueSale = unityValueSale;
    }

    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
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
        if (!(o instanceof TitleRate)) return false;
        TitleRate titleRate = (TitleRate) o;
        return getRateId() == titleRate.getRateId() &&
                getTitleId() == titleRate.getTitleId() &&
                Objects.equals(getQuoteTime(), titleRate.getQuoteTime()) &&
                Objects.equals(getRatePurchase(), titleRate.getRatePurchase()) &&
                Objects.equals(getRateSale(), titleRate.getRateSale()) &&
                Objects.equals(getUnityValuePurchase(), titleRate.getUnityValuePurchase()) &&
                Objects.equals(getUnityValueSale(), titleRate.getUnityValueSale());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRateId(), getTitleId(), getQuoteTime(), getRatePurchase(), getRateSale(), getUnityValuePurchase(), getUnityValueSale());
    }

    @Override
    public String toString() {
        return "TitleRate{" +
                "rateId=" + rateId +
                ", titleId=" + titleId +
                ", quoteTime='" + quoteTime + '\'' +
                ", ratePurchase=" + ratePurchase +
                ", rateSale=" + rateSale +
                ", unityValuePurchase=" + unityValuePurchase +
                ", unityValueSale=" + unityValueSale +
                '}';
    }
}

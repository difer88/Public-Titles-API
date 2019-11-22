package com.diegofernandes.publictitlesapi.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Builder
@Getter
@Setter
public class TitleInfoDTO {

    private Integer id;
    private String name;
    private String dueDate;
    private String quoteTime;
    private Double ratePurchase;
    private Double rateSale;
    private BigDecimal unityValuePurchase;
    private BigDecimal unityValueSale;

    public void fillTitleDTO(TitleRate titleRate) {
        this.id = titleRate.getTitle().getId();
        this.name = titleRate.getTitle().getName();
        this.dueDate = titleRate.getTitle().getDueDate();
        this.quoteTime = titleRate.getQuoteTime();
        this.ratePurchase = titleRate.getRatePurchase();
        this.rateSale = titleRate.getRateSale();
        this.unityValuePurchase = titleRate.getUnityValuePurchase();
        this.unityValueSale = titleRate.getUnityValueSale();
    }
}

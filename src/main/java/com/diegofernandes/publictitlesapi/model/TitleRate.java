package com.diegofernandes.publictitlesapi.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@Getter
@Setter
@Entity
@Table(name = "titles_rate_tbl")
public class TitleRate {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "rate_id")
    private Integer rateId;

    @Column(name = "quote_time")
    private String quoteTime;
    @Column(name = "rate_purchase")
    private Double ratePurchase;
    @Column(name = "rate_sale")
    private Double rateSale;
    @Column(name = "unity_value_purchase")
    private BigDecimal unityValuePurchase;
    @Column(name = "unity_value_sale")
    private BigDecimal unityValueSale;

    @ManyToOne
    @JoinColumn(name = "title_id", nullable = false)
    private Title title;

}

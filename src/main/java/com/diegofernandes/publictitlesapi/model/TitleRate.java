package com.diegofernandes.publictitlesapi.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "titles_rate_tbl")
public class TitleRate {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "rate_id")
    private Integer rateId;
    @Column(name = "title_id")
    private Integer titleId;
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

    @Transient
    private Title title;

}

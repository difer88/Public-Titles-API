package com.diegofernandes.publictitlesapi.repository;

import com.diegofernandes.publictitlesapi.model.TitleRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TitleRateRepository extends JpaRepository<TitleRate, Long> {

    @Query("select r from TitleRate r where rateId = (select max(rateId) from TitleRate where titleId = ?1)")
    TitleRate getLastRate(@Param("titleId") Integer titleId);

    TitleRate findByRateId(Integer rateId);

}

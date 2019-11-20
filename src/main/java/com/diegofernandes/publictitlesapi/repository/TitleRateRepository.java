package com.diegofernandes.publictitlesapi.repository;

import com.diegofernandes.publictitlesapi.model.TitleRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleRateRepository extends JpaRepository<TitleRate, Long> {

    List<TitleRate> findAllByTitleIdOrderByRateIdAsc(Integer titleId);

}

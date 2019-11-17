package com.diegofernandes.publictitlesapi.repository;

import com.diegofernandes.publictitlesapi.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleRepository extends JpaRepository<Title, Long>{

    Title findByName(String name);

    List<String> getTitlesListByWebsite();

}

package com.diegofernandes.publictitlesapi.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "titles_tbl")
public class Title {

    @Id
    @Column(name = "title_id")
    private Integer id;

    @Column(name = "title_name")
    private String name;
    @Column(name = "due_date")
    private String dueDate;

}

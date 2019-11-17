package com.diegofernandes.publictitlesapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

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

    public Title() {
    }

    public Title(Integer id, String name, String dueDate) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Title)) return false;
        Title title = (Title) o;
        return Objects.equals(getId(), title.getId()) &&
                Objects.equals(getName(), title.getName()) &&
                Objects.equals(getDueDate(), title.getDueDate());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getDueDate());
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}

package ru.verlioka.cmf.appservices.mudrichenko.models;

import javax.persistence.*;

@Entity
@Table(name = "criminal_articles")
public class CriminalArticlesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @Column( name = "number" )
    private int number;

    @Column( name = "description" )
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CriminalArticlesEntity{" +
                "id=" + id +
                ", number=" + number + '\'' +
                ", description=" + description + '\'' +
                '}';
    }
}

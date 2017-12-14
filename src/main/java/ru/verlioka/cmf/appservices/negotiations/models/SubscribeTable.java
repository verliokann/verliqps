package ru.verlioka.cmf.appservices.negotiations.models;

import javax.persistence.*;

@Entity
@Table(name = "subscriber_table")
public class SubscribeTable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subscriber")
    private Long id;

    @Column(name = "name")
    private String Name;

    @Column( name = "surname" )
    private String Surname;

    @ManyToOne
    @JoinColumn(name = "id_negotiations")
    private NegotiationsTable negotiations;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }
    public void setSurname(String Surname) {
        this.Surname = Surname;
    }



}
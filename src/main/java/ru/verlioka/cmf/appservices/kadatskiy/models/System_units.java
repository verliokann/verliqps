package ru.verlioka.cmf.appservices.kadatskiy.models;

import javax.persistence.*;

/**
 * Created by Костя on 19.12.2017.
 */

@Entity
@Table(name = "system_units")
public class System_units {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn( name = "motherboard" )
    private Motherboards motherboard;

    @Column(name = "name")
    private String name;

    @Column(name = "manufacturer")
    private String manufacturer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Motherboards getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboards motherboard) {
        this.motherboard = motherboard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "System_units{" +
                "id=" + id +
                ", motherboard=" + motherboard +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}

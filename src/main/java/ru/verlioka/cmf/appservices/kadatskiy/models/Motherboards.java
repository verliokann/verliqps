package ru.verlioka.cmf.appservices.kadatskiy.models;



import javax.persistence.*;

/**
 * Created by Костя on 19.12.2017.
 */

@Entity
@Table (name = "Motherboards")

public class Motherboards {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn( name = "processor" )
    private Processors processor;

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

    public Processors getProcessor() {
        return processor;
    }

    public void setProcessor(Processors processor) {
        this.processor = processor;
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
        return "Motherboards{" +
                "id=" + id +
                ", processor=" + processor +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}


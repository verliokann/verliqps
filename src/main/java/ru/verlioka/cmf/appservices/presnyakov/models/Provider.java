package ru.verlioka.cmf.appservices.presnyakov.models;

import javax.persistence.*;

@Entity
@Table(name = "provider")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @Column( name = "name" )
    private String name;

    @Column( name = "director" )
    private String director;

    @ManyToOne
    @JoinColumn( name = "city_id" )
    private City city;

    @Override
    public String toString() {
        return "Provider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", city=" + city +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Provider provider = (Provider) o;

        if (id != null ? !id.equals(provider.id) : provider.id != null) return false;
        if (name != null ? !name.equals(provider.name) : provider.name != null) return false;
        if (director != null ? !director.equals(provider.director) : provider.director != null) return false;
        return city != null ? city.equals(provider.city) : provider.city == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city_id) {
        this.city = city_id;
    }


}

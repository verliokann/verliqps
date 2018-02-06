package ru.verlioka.cmf.appservices.phonecalls.models;

import javax.persistence.*;


@Entity
@Table(name = "city")


public class cityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long Id;


    @Column( name = "cityname" )
    private String cityName;

    @Override
    public String toString() {
        return "cityEntity{" +
                "Id=" + Id +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        cityEntity that = (cityEntity) o;

        if (Id != null ? !Id.equals(that.Id) : that.Id != null) return false;
        return cityName != null ? cityName.equals(that.cityName) : that.cityName == null;
    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        return result;
    }

    public Long getId() {

        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}

package ru.verlioka.cmf.appservices.roglik.models;

import javax.persistence.*;

@Entity
@Table(name = "hotels")
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private CountryEntity country;

    @Column(name = "hotel_name", nullable = false)
    private String name;

    @Column(name = "hotel_quality", nullable = false)
    private Integer quality;

    public HotelEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity countryId) {
        this.country = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HotelEntity that = (HotelEntity) o;

        return getId().equals(that.getId()) &&
                getCountry().equals(that.getCountry()) &&
                getName().equals(that.getName()) &&
                getQuality().equals(that.getQuality());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getCountry().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getQuality().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "HotelEntity{" +
                "id=" + id +
                ", country=" + country +
                ", name='" + name + '\'' +
                ", quality=" + quality +
                '}';
    }
}

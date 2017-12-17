package ru.verlioka.cmf.appservices.tourvauchers.models;

import javax.persistence.*;

@Entity
@Table(name = "hotels")
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id", nullable = false, unique = true)
    private Long id;

    @OneToOne
    @JoinColumn(name = "country_id", nullable = false)
    private CountryEntity country;

    @Column(name = "hotel_name", nullable = false)
    private String name;

    @Column(name = "hotel_rating", nullable = false)
    private Integer rating;
    
    @Column(name = "seaside", nullable = false)
    private String seaside;
    
    @Column(name = "beachtype", nullable = false)
    private String beachtype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getSeaside() {
		return seaside;
	}

	public void setSeaside(String seaside) {
		this.seaside = seaside;
	}

	public String getBeachtype() {
		return beachtype;
	}

	public void setBeachtype(String beachtype) {
		this.beachtype = beachtype;
	}
    
	@Override
    public String toString() {
        return "HotelEntity{" +
                "id=" + id +
                ", country=" + country +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", seaside=" + seaside +
                ", beachtype=" + beachtype +
                '}';
    }
}

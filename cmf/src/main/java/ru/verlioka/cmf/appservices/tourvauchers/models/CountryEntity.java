package ru.verlioka.cmf.appservices.tourvauchers.models;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "country_name", nullable = false)
    private String name;

    @Column(name = "visa_required", nullable = false)
    private Boolean visaRequired;

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

	public Boolean getVisaRequired() {
		return visaRequired;
	}

	public void setVisaRequired(Boolean visaRequired) {
		this.visaRequired = visaRequired;
	}
    
	 @Override
	    public String toString() {
	        return "CountryEntity{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", visaRequired=" + visaRequired +
	                '}';
	    }
    
}
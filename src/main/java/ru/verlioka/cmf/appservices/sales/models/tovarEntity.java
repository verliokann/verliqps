package ru.verlioka.cmf.appservices.sales.models;

import javax.persistence.*;


@Entity
@Table(name = "tovar")


public class tovarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long Id;


    @Column( name = "nazvanie" )
    private String nazvanie;

    @Column( name = "vid" )
    private String vid;

    @ManyToOne
    @JoinColumn( name = "vid" )
    private vidTovaraEntity id;


    @Column( name = "opisanie" )
    private String opisanie;

    @Override
    public String toString() {
        return "tovarEntity{" +
                "Id=" + Id +
                ", nazvanie='" + nazvanie + '\'' +
                ", vid='" + vid + '\'' +
                ", opisanie='" + opisanie + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        tovarEntity that = (tovarEntity) o;

        if (Id != null ? !Id.equals(that.Id) : that.Id != null)
        if (nazvanie != null ? !nazvanie.equals(that.nazvanie) : that.nazvanie != null) return false;
        if (vid != null ? !vid.equals(that.vid) : that.vid != null) return false;
        return opisanie != null ? opisanie.equals(that.opisanie) : that.opisanie == null;


    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (nazvanie != null ? nazvanie.hashCode() : 0);
        result = 31 * result + (vid != null ? vid.hashCode() : 0);
        result = 31 * result + (opisanie != null ? opisanie.hashCode() : 0);
        return result;
    }

    public Long getId() {

        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }



    public String getnazvanie() {
        return nazvanie;
    }

    public void setnazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public String getvid() {
        return vid;
    }

    public void setvid(String vid) {
        this.vid = vid;
    }

    public String getOpisanie() {
        return opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }
}

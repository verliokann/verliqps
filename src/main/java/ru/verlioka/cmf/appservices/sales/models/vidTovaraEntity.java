package ru.verlioka.cmf.appservices.sales.models;

import javax.persistence.*;


@Entity
@Table(name = "vidTovara")


public class vidTovaraEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @Column( name = "vid" )
    private String vid;


    @Override
    public String toString() {
        return "vidTovaraEntity{" +
                "id=" + id +
                ", vid='" + vid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ru.verlioka.cmf.appservices.sales.models.vidTovaraEntity that = (ru.verlioka.cmf.appservices.sales.models.vidTovaraEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (vid != null ? !vid.equals(that.vid) : that.vid != null) return true;

        return false;
    }


    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (vid != null ? vid.hashCode() : 0);

        return result;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getvid() {
        return vid;
    }

    public void setvid(String vid) {
        this.vid = vid;
    }

}

package ru.verlioka.cmf.appservices.sales.models;


import javax.persistence.*;


@Entity
@Table(name = "prodazhi")



public class prodazhiEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;


    @Column( name = "idSotrudnika" )
    private Long idSotrudnika;

    @OneToMany
    @JoinColumn( name = "idSotrudnika" )
    private sotrudnikiEntity idSotr;

    @Column( name = "idTovara" )
    private Long idTovara;

    @OneToMany
    @JoinColumn( name = "idTovara" )
    private tovarEntity idTov;

    @Column( name = "vidTovara" )
    private Long vidTovara;

    @OneToMany
    @JoinColumn( name = "vidTovara" )
    private vidTovaraEntity idVid;

    @Column( name = "dataZakaza" )
    private String dataZakaza;

    @Column( name = "stoimostTovara" )
    private Long stoimostTovara;


    @Override
    public String toString() {
        return "prodazhiEntity{" +
                "id=" + id +
                ", idSotrudnika='" + idSotrudnika + '\'' +
                ", idTovara=" + idTovara +
                ", vidTovara=" + vidTovara +
                ", dataZakaza=" + dataZakaza +
                ", stoimost=" + stoimostTovara +
                '}';
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSotrudnika() {
        return idSotrudnika;
    }

    public void setIdSotrudnika(Long idSotrudnika) {
        this.idSotrudnika = idSotrudnika;
    }

    public Long getIdTovara() {
        return idTovara;
    }

    public void setIdTovara(Long idTovara) {
        this.idTovara = idTovara;
    }

    public Long getVidTovara() {
        return vidTovara;
    }

    public void setVidTovara(Long vidTovara) {
        this.vidTovara = vidTovara;
    }

    public String getDataZakaza() {
        return dataZakaza;
    }

    public void setDataZakaza(String dataZakaza) {
        this.dataZakaza = dataZakaza;
    }

    public Long getStoimostTovara() {
        return stoimostTovara;
    }

    public void setStoimostTovara(Long stoimostTovara) {
        this.stoimostTovara = stoimostTovara;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ru.verlioka.cmf.appservices.sales.models.prodazhiEntity that = (ru.verlioka.cmf.appservices.sales.models.prodazhiEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idSotrudnika != null ? idSotrudnika.equals(that.idSotrudnika) : that.idSotrudnika != null) return false;
        if (idTovara != null ? !idTovara.equals(that.idTovara) : that.idTovara != null) return false;
        if (vidTovara != null ? !vidTovara.equals(that.vidTovara) : that.vidTovara != null) return false;
        if (stoimostTovara != null ? !stoimostTovara.equals(that.stoimostTovara) : that.stoimostTovara != null) return false;
        return dataZakaza != null ? dataZakaza.equals(that.dataZakaza) : that.dataZakaza == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idSotrudnika != null ? idSotrudnika.hashCode() : 0);
        result = 31 * result + (idTovara != null ? idTovara.hashCode() : 0);
        result = 31 * result + (vidTovara != null ? vidTovara.hashCode() : 0);
        result = 31 * result + (dataZakaza != null ? dataZakaza.hashCode() : 0);
        result = 31 * result + (stoimostTovara != null ? stoimostTovara.hashCode() : 0);
        return result;
    }

}

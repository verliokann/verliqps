package ru.verlioka.cmf.appservices.sales.models;

import javax.persistence.*;


@Entity
@Table(name = "sotrudniki")


public class sotrudnikiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long Id;

    @Column( name = "FIO" )
    private String FIO;


    @Column(name = "dolzhnost")
    private String dolzhnost;


    @Column(name = "telefon")
    private String telefon;


    @Column(name = "birthDate")
    private String birthDate;


    @Column(name = "obrazovanie")
    private String obrazovanie;


    @Column(name = "adress")
    private String adress;

    @Override
    public String toString() {
        return "sotrudnikiEntity{" +
                "Id=" + Id +
                ", FIO='" + FIO + '\'' +
                ", dolzhnost=" + dolzhnost +
                ", telefon=" + telefon +
                ", birthDate=" + birthDate +
                ", obrazovanie=" + obrazovanie +
                ", adress=" + adress +
                '}';
    }



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getDolzhnost() {
        return dolzhnost;
    }

    public void setDolzhnost(String dolzhnost) {
        this.dolzhnost = dolzhnost;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getObrazovanie() {
        return obrazovanie;
    }

    public void setObrazovanie(String obrazovanie) {
        this.obrazovanie = obrazovanie;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ru.verlioka.cmf.appservices.sales.models.sotrudnikiEntity that = (ru.verlioka.cmf.appservices.sales.models.sotrudnikiEntity) o;

        if (Id != null ? !Id.equals(that.Id) : that.Id != null) return false;
        if (FIO != null ? !FIO.equals(that.FIO) : that.FIO != null) return false;
        if (dolzhnost != null ? !dolzhnost.equals(that.dolzhnost) : that.dolzhnost != null) return false;
        if (telefon != null ? !telefon.equals(that.telefon) : that.telefon != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (obrazovanie != null ? !obrazovanie.equals(that.obrazovanie) : that.obrazovanie != null) return false;
        return adress != null ? adress.equals(that.adress) : that.adress == null;
    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (FIO != null ? FIO.hashCode() : 0);
        result = 31 * result + (dolzhnost != null ? dolzhnost.hashCode() : 0);
        result = 31 * result + (telefon != null ? telefon.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (obrazovanie != null ? obrazovanie.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        return result;
    }


}

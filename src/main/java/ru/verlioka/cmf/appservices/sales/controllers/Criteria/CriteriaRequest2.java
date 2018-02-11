package ru.verlioka.cmf.appservices.sales.controllers.Criteria;



public class CriteriaRequest2 {

    private String FIO;
    private String adress;
    private String birthDate;
    private String obrazovanie;
    private String dolzhnost;
    private String telefon;

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }


    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

}

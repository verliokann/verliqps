package ru.verlioka.cmf.appservices.k0tk0vbol.controllers.reports;

/**
 * Created by Max on 13.12.2017.
 */
public class SickInfReq {

    private String FIO;
    private String Dname;
    private int NumKoiki;
    private String Data;
    private String DocName;
    private String Diagnoz;

    public SickInfReq(String FIO, String dname, int numKoiki, String data, String docName, String diagnoz) {
        this.FIO = FIO;
        this.Dname = dname;
        this.NumKoiki = numKoiki;
        this.Data = data;
        this.DocName = docName;
        this.Diagnoz = diagnoz;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        this.Dname = dname;
    }

    public int getNumKoiki() {
        return NumKoiki;
    }

    public void setNumKoiki(int numKoiki) {
        this.NumKoiki = numKoiki;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        this.Data = data;
    }

    public String getDocName() {
        return DocName;
    }

    public void setDocName(String docName) {
        this.DocName = docName;
    }

    public String getDiagnoz() {
        return Diagnoz;
    }

    public void setDiagnoz(String diagnoz) {
        this.Diagnoz = diagnoz;
    }
}

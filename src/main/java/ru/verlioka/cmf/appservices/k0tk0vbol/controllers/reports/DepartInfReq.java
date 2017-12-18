package ru.verlioka.cmf.appservices.k0tk0vbol.controllers.reports;

/**
 * Created by Max on 13.12.2017.
 */
public class DepartInfReq {

    private String DName;
    private String FIO;
    private int mesta;

    public DepartInfReq(String DName, String FIO, int mesta) {
        this.DName = DName;
        this.FIO = FIO;
        this.mesta = mesta;
    }

    public String getDName() {
        return DName;
    }

    public void setDName(String DName) {
        this.DName = DName;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getMesta() {
        return mesta;
    }

    public void setMesta(int mesta) {
        this.mesta = mesta;
    }

    @Override
    public String toString() {
        return "DepartInfReq{" +
                "DName='" + DName + '\'' +
                ", FIO='" + FIO + '\'' +
                ", mesta=" + mesta +
                '}';
    }
}

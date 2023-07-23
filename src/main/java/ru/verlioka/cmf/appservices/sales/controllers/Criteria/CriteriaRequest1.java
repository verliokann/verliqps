package ru.verlioka.cmf.appservices.sales.controllers.Criteria;




public class CriteriaRequest1 {

    private String FIO;
    private Long idZakaza;
    private String nazvanie;
    private String stoimostTovara;
    private String dataZakaza;
    private Long vidTovara;

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Long getIdZakaza() {
        return idZakaza;
    }

    public void setIdZakaza(Long idZakaza) {
        this.idZakaza = idZakaza;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public String getStoimostTovara() {
        return stoimostTovara;
    }

    public void setStoimostTovara(String stoimostTovara) {
        this.stoimostTovara = stoimostTovara;
    }

    public String getDataZakaza() {
        return dataZakaza;
    }

    public void setDataZakaza(String dataZakaza) {
        this.dataZakaza = dataZakaza;
    }

    public Long getVidTovara() {
        return vidTovara;
    }

    public void setVidTovara(Long vidTovara) {
        this.vidTovara = vidTovara;
    }

}

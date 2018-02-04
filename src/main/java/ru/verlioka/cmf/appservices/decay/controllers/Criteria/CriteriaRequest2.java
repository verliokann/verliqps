package ru.verlioka.cmf.appservices.decay.controllers.Criteria;

public class CriteriaRequest2 {

    private String people_FIO;
    private String people_Oklad;
    private String people_zarp_chas;
    private Long job_kolichestvo;

    public String getpeople_FIO() {
        return people_FIO;
    }

    public void setpeople_FIO(String people_FIO) {
        this.people_FIO = people_FIO;
    }

    public String getpeople_Oklad() {
        return people_Oklad;
    }

    public void setpeople_Oklad(String people_Oklad) {
        this.people_Oklad = people_Oklad;
    }

    public String getpeople_zarp_chas() {
        return people_zarp_chas;
    }

    public void setpeople_zarp_chas(String people_zarp_chas) {
        this.people_zarp_chas = people_zarp_chas;
    }

    public Long getjob_kolichestvo() {
        return job_kolichestvo;
    }

    public void setjob_kolichestvo(Long job_kolichestvo) {
        this.job_kolichestvo = job_kolichestvo;
    }
}

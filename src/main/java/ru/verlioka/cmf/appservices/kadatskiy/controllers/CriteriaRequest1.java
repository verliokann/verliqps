package ru.verlioka.cmf.appservices.kadatskiy.controllers;

public class CriteriaRequest1 {

    private String motherboards_name;
    private String motherboards_manufacturer;
    private String processors_name;
    private String processors_manufacturer;

    public String getMotherboards_name() {
        return motherboards_name;
    }

    public void setMotherboards_name(String motherboards_name) {
        this.motherboards_name = motherboards_name;
    }

    public String getMotherboards_manufacturer() {
        return motherboards_manufacturer;
    }

    public void setMotherboards_manufacturer(String motherboards_manufacturer) {
        this.motherboards_manufacturer = motherboards_manufacturer;
    }

    public String getProcessors_name() {
        return processors_name;
    }

    public void setProcessors_name(String processors_name) {
        this.processors_name = processors_name;
    }

    public String getProcessors_manufacturer() {
        return processors_manufacturer;
    }

    public void setProcessors_manufacturer(String processors_manufacturer) {
        this.processors_manufacturer = processors_manufacturer;
    }
}

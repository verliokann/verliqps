package ru.verlioka.cmf.appservices.mudrichenko.controllers.Criteria;

import java.sql.Date;

public class CriteriaRequest1 {

    private String defendants_name;
    private String defendants_alias;
    private int article_number;
    private String born_date;
    private String date_of_trial;
    private String article_description;
    private String address;
    private String portrait;
    private boolean is_uncovered;
    private String investigator;
    private String specialSigns;

    public String getDefendants_name() {
        return defendants_name;
    }

    public void setDefendants_name(String defendants_name) {
        this.defendants_name = defendants_name;
    }

    public String getDefendants_alias() {
        return defendants_alias;
    }

    public void setDefendants_alias(String defendants_alias) {
        this.defendants_alias = defendants_alias;
    }

    public int getArticle_number() {
        return article_number;
    }

    public void setArticle_number(int article_number) {
        this.article_number = article_number;
    }

    public String getBorn_date() {
        return born_date;
    }

    public void setBorn_date(String born_date) {
        this.born_date = born_date;
    }

    public String getDate_of_trial() {
        return date_of_trial;
    }

    public void setDate_of_trial(String date_of_trial) {
        this.date_of_trial = date_of_trial;
    }

    public String getArticle_description() {
        return article_description;
    }

    public void setArticle_description(String article_description) {
        this.article_description = article_description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public boolean getIsUncovered() {
        return is_uncovered;
    }

    public void setIs_uncovered(boolean is_uncovered) {
        this.is_uncovered = is_uncovered;
    }

    public String getInvestigator() {
        return investigator;
    }

    public void setInvestigator(String investigator) {
        this.investigator = investigator;
    }

    public String getSpecialSigns() {
        return specialSigns;
    }

    public void setSpecialSigns(String specialSigns) {
        this.specialSigns = specialSigns;
    }

}

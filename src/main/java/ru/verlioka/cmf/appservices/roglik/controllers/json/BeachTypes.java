package ru.verlioka.cmf.appservices.roglik.controllers.json;

import java.util.Objects;

public class BeachTypes {
    private String beachType;
    private Double totalCost;
    private Integer vouchersAmount;

    public BeachTypes() {
    }

    public String getBeachType() {
        return beachType;
    }

    public void setBeachType(String beachType) {
        this.beachType = beachType;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getVouchersAmount() {
        return vouchersAmount;
    }

    public void setVouchersAmount(Integer vouchersAmount) {
        this.vouchersAmount = vouchersAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeachTypes that = (BeachTypes) o;
        return Objects.equals(getBeachType(), that.getBeachType()) &&
                Objects.equals(getTotalCost(), that.getTotalCost()) &&
                Objects.equals(getVouchersAmount(), that.getVouchersAmount());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getBeachType(), getTotalCost(), getVouchersAmount());
    }

    @Override
    public String toString() {
        return "BeachTypes{" +
                "beachType='" + beachType + '\'' +
                ", totalCost=" + totalCost +
                ", vouchersAmount=" + vouchersAmount +
                '}';
    }
}


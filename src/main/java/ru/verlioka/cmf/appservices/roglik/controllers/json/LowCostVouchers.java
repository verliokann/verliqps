package ru.verlioka.cmf.appservices.roglik.controllers.json;

import java.util.Objects;

public class LowCostVouchers {
    private String countryName;
    private String beachName;
    private Double cost;

    public LowCostVouchers() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getBeachName() {
        return beachName;
    }

    public void setBeachName(String beachName) {
        this.beachName = beachName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LowCostVouchers that = (LowCostVouchers) o;
        return Objects.equals(getCountryName(), that.getCountryName()) &&
                Objects.equals(getBeachName(), that.getBeachName()) &&
                Objects.equals(getCost(), that.getCost());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCountryName(), getBeachName(), getCost());
    }

    @Override
    public String toString() {
        return "LowCostVouchers{" +
                "countryName='" + countryName + '\'' +
                ", beachName='" + beachName + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}

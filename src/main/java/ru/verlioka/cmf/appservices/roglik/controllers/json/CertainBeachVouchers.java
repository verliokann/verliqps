package ru.verlioka.cmf.appservices.roglik.controllers.json;

import java.util.List;
import java.util.Objects;

public class CertainBeachVouchers {
    private List<CertainBeachVoucher> vouchers;
    private Double totalCost;
    private Double totalDiscountedCost;

    public CertainBeachVouchers() {
    }

    public List<CertainBeachVoucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<CertainBeachVoucher> vouchers) {
        this.vouchers = vouchers;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Double getTotalDiscountedCost() {
        return totalDiscountedCost;
    }

    public void setTotalDiscountedCost(Double totalDiscountedCost) {
        this.totalDiscountedCost = totalDiscountedCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertainBeachVouchers that = (CertainBeachVouchers) o;
        return Objects.equals(getVouchers(), that.getVouchers()) &&
                Objects.equals(getTotalCost(), that.getTotalCost()) &&
                Objects.equals(getTotalDiscountedCost(), that.getTotalDiscountedCost());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getVouchers(), getTotalCost(), getTotalDiscountedCost());
    }

    @Override
    public String toString() {
        return "CertainBeachVouchers{" +
                "vouchers=" + vouchers +
                ", totalCost=" + totalCost +
                ", totalDiscountedCost=" + totalDiscountedCost +
                '}';
    }
}

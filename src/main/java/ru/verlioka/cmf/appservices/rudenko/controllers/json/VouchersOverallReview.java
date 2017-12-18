package ru.verlioka.cmf.appservices.rudenko.controllers.json;

import java.util.List;

public class VouchersOverallReview {
    private List<VoucherReview> vouchers;
    private Double overallCost;
    private Double overallFullCost;

    public VouchersOverallReview() {
    }

    public List<VoucherReview> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<VoucherReview> vouchers) {
        this.vouchers = vouchers;
    }

    public Double getOverallCost() {
        return overallCost;
    }

    public void setOverallCost(Double overallCost) {
        this.overallCost = overallCost;
    }

    public Double getOverallFullCost() {
        return overallFullCost;
    }

    public void setOverallFullCost(Double overallFullCost) {
        this.overallFullCost = overallFullCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VouchersOverallReview that = (VouchersOverallReview) o;

        return getVouchers().equals(that.getVouchers()) &&
                getOverallCost().equals(that.getOverallCost()) &&
                getOverallFullCost().equals(that.getOverallFullCost());
    }

    @Override
    public int hashCode() {
        int result = getVouchers().hashCode();
        result = 31 * result + getOverallCost().hashCode();
        result = 31 * result + getOverallFullCost().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "VouchersOverallReview{" +
                "vouchers=" + vouchers +
                ", overallCost=" + overallCost +
                ", overallFullCost=" + overallFullCost +
                '}';
    }
}

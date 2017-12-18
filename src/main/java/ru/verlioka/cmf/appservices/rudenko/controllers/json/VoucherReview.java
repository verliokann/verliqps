package ru.verlioka.cmf.appservices.rudenko.controllers.json;

public class VoucherReview {
    private Long id;
    private Double cost;
    private Double fullCost;

    public VoucherReview() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getFullCost() {
        return fullCost;
    }

    public void setFullCost(Double fullCost) {
        this.fullCost = fullCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VoucherReview that = (VoucherReview) o;

        return getId().equals(that.getId()) &&
                getCost().equals(that.getCost()) &&
                getFullCost().equals(that.getFullCost());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getCost().hashCode();
        result = 31 * result + getFullCost().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "VoucherReview{" +
                "id=" + id +
                ", cost=" + cost +
                ", fullCost=" + fullCost +
                '}';
    }
}

package ru.verlioka.cmf.appservices.suppie.models;

import javax.persistence.*;

@Entity
@Table(name = "tariffs")
public class TariffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tariff_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "monthly_payment", nullable = false)
    private Double monthlyPayment;

    @Column(name = "minutes_per_month")
    private Integer minutesPerMonth = -1;

    public TariffEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Integer getMinutesPerMonth() {
        return minutesPerMonth;
    }

    public void setMinutesPerMonth(Integer minutesPerMonth) {
        if (minutesPerMonth == null) {
            this.minutesPerMonth = -1;
        } else {
            this.minutesPerMonth = minutesPerMonth;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TariffEntity that = (TariffEntity) o;

        return getId().equals(that.getId()) &&
                getMonthlyPayment().equals(that.getMonthlyPayment()) &&
                getMinutesPerMonth().equals(that.getMinutesPerMonth());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getMonthlyPayment().hashCode();
        result = 31 * result + getMinutesPerMonth().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TariffEntity{" +
                "id=" + id +
                ", monthlyPayment=" + monthlyPayment +
                ", minutesPerMonth=" + minutesPerMonth +
                '}';
    }
}

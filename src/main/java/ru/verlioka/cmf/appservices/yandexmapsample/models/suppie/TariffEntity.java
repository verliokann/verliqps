package ru.verlioka.cmf.appservices.yandexmapsample.models.suppie;

import javax.persistence.*;

@Entity
@Table(name = "tariffs")
public class TariffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tariff_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "operator_id")
    private OperatorEntity operator;

    @Column(name = "monthly_payment")
    private Integer monthlyPayment;

    @Column(name = "minutes_per_month")
    private Integer minutesPerMonth = -1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OperatorEntity getOperator() {
        return operator;
    }

    public void setOperator(OperatorEntity operator) {
        this.operator = operator;
    }

    public Integer getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Integer monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Integer getMinutesPerMonth() {
        return minutesPerMonth;
    }

    public void setMinutesPerMonth(Integer minutesPerMonth) {
        this.minutesPerMonth = minutesPerMonth;
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
                getOperator().equals(that.getOperator()) &&
                (getMonthlyPayment() != null ? getMonthlyPayment().equals(that.getMonthlyPayment()) : that.getMonthlyPayment() == null) &&
                (getMinutesPerMonth() != null ? getMinutesPerMonth().equals(that.getMinutesPerMonth()) : that.getMinutesPerMonth() == null);
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getOperator().hashCode();
        result = 31 * result + (getMonthlyPayment() != null ? getMonthlyPayment().hashCode() : 0);
        result = 31 * result + (getMinutesPerMonth() != null ? getMinutesPerMonth().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TariffEntity{" +
                "id=" + id +
                ", operator=" + operator +
                ", monthlyPayment=" + monthlyPayment +
                ", minutesPerMonth=" + minutesPerMonth +
                '}';
    }
}

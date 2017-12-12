package ru.verlioka.cmf.appservices.suppie.controllers.json;

// № телефона, ФИО, месяц, сумма к оплате, сумма долга, сумма оплаты
// Подразумевается, что:
// Сумма к оплате = сумма долга + стоимость тарифа
// Сумма оплаты = сумма оплат мобильной связи в течение месяца
public class BalanceReport {
    private String phoneNumber;
    private String name;
    private String month;
    private Double requiredToPay;
    private Double debtAmount;
    private Double paymentsAmount;

    public BalanceReport() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getRequiredToPay() {
        return requiredToPay;
    }

    public void setRequiredToPay(Double requiredToPay) {
        this.requiredToPay = requiredToPay;
    }

    public Double getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(Double debtAmount) {
        this.debtAmount = debtAmount;
    }

    public Double getPaymentsAmount() {
        return paymentsAmount;
    }

    public void setPaymentsAmount(Double paymentsAmount) {
        this.paymentsAmount = paymentsAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BalanceReport that = (BalanceReport) o;

        return (getPhoneNumber() != null ? getPhoneNumber().equals(that.getPhoneNumber()) : that.getPhoneNumber() == null) &&
                (getName() != null ? getName().equals(that.getName()) : that.getName() == null) &&
                (getMonth() != null ? getMonth().equals(that.getMonth()) : that.getMonth() == null) &&
                (getRequiredToPay() != null ? getRequiredToPay().equals(that.getRequiredToPay()) : that.getRequiredToPay() == null) &&
                (getDebtAmount() != null ? getDebtAmount().equals(that.getDebtAmount()) : that.getDebtAmount() == null) &&
                (getPaymentsAmount() != null ? getPaymentsAmount().equals(that.getPaymentsAmount()) : that.getPaymentsAmount() == null);
    }

    @Override
    public int hashCode() {
        int result = getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getMonth() != null ? getMonth().hashCode() : 0);
        result = 31 * result + (getRequiredToPay() != null ? getRequiredToPay().hashCode() : 0);
        result = 31 * result + (getDebtAmount() != null ? getDebtAmount().hashCode() : 0);
        result = 31 * result + (getPaymentsAmount() != null ? getPaymentsAmount().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BalanceReport{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", month='" + month + '\'' +
                ", requiredToPay=" + requiredToPay +
                ", debtAmount=" + debtAmount +
                ", paymentsAmount=" + paymentsAmount +
                '}';
    }
}

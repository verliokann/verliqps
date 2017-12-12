package ru.verlioka.cmf.appservices.yandexmapsample.controllers.suppie.json;

// № телефона, ФИО, адрес, месяц, сумма оплаты (за месяц), количество минут
public class PaymentsReport {
    private String phoneNumber;
    private String name;
    private String address;
    private String month;
    private Double paymentsAmount;
    private Integer minutesAmount;

    public PaymentsReport() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getPaymentsAmount() {
        return paymentsAmount;
    }

    public void setPaymentsAmount(Double paymentsAmount) {
        this.paymentsAmount = paymentsAmount;
    }

    public Integer getMinutesAmount() {
        return minutesAmount;
    }

    public void setMinutesAmount(Integer minutesAmount) {
        this.minutesAmount = minutesAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PaymentsReport that = (PaymentsReport) o;

        return (getPhoneNumber() != null ? getPhoneNumber().equals(that.getPhoneNumber()) : that.getPhoneNumber() == null) &&
                (getName() != null ? getName().equals(that.getName()) : that.getName() == null) &&
                (getAddress() != null ? getAddress().equals(that.getAddress()) : that.getAddress() == null) &&
                (getMonth() != null ? getMonth().equals(that.getMonth()) : that.getMonth() == null) &&
                (getPaymentsAmount() != null ? getPaymentsAmount().equals(that.getPaymentsAmount()) : that.getPaymentsAmount() == null) &&
                (getMinutesAmount() != null ? getMinutesAmount().equals(that.getMinutesAmount()) : that.getMinutesAmount() == null);
    }

    @Override
    public int hashCode() {
        int result = getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getMonth() != null ? getMonth().hashCode() : 0);
        result = 31 * result + (getPaymentsAmount() != null ? getPaymentsAmount().hashCode() : 0);
        result = 31 * result + (getMinutesAmount() != null ? getMinutesAmount().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PaymentsReport{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", month='" + month + '\'' +
                ", paymentsAmount=" + paymentsAmount +
                ", minutesAmount=" + minutesAmount +
                '}';
    }
}

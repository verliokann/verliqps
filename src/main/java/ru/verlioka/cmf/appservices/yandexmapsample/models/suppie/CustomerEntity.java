package ru.verlioka.cmf.appservices.yandexmapsample.models.suppie;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false, unique = true)
    private Long id;

    @OneToOne
    @JoinColumn(name = "tariff_id", nullable = false)
    private TariffEntity tariff;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TariffEntity getTariff() {
        return tariff;
    }

    public void setTariff(TariffEntity tariff) {
        this.tariff = tariff;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerEntity that = (CustomerEntity) o;

        return getId().equals(that.getId()) &&
                getTariff().equals(that.getTariff()) &&
                getPhoneNumber().equals(that.getPhoneNumber()) &&
                getName().equals(that.getName()) &&
                getAddress().equals(that.getAddress());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getTariff().hashCode();
        result = 31 * result + getPhoneNumber().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getAddress().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", tariff=" + tariff +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

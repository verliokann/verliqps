package ru.verlioka.cmf.appservices.yandexmapsample.models.suppie;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "operator_id")
    private OperatorEntity operator;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomerEntity that = (CustomerEntity) o;

        return getId().equals(that.getId()) &&
                getOperator().equals(that.getOperator()) &&
                getPhoneNumber().equals(that.getPhoneNumber()) &&
                getName().equals(that.getName()) &&
                getAddress().equals(that.getAddress());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getOperator().hashCode();
        result = 31 * result + getPhoneNumber().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getAddress().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", operator=" + operator +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

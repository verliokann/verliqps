package ru.verlioka.cmf.appservices.yandexmapsample.models.suppie;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "payments")
public class PaymentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "amount")
    private Integer amount;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PaymentsEntity that = (PaymentsEntity) o;

        return getId().equals(that.getId()) &&
                getCustomer().equals(that.getCustomer()) &&
                (getCreatedAt() != null ? getCreatedAt().equals(that.getCreatedAt()) : that.getCreatedAt() == null) &&
                (getAmount() != null ? getAmount().equals(that.getAmount()) : that.getAmount() == null);
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getCustomer().hashCode();
        result = 31 * result + (getCreatedAt() != null ? getCreatedAt().hashCode() : 0);
        result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PaymentsEntity{" +
                "id=" + id +
                ", customer=" + customer +
                ", createdAt=" + createdAt +
                ", amount=" + amount +
                '}';
    }
}

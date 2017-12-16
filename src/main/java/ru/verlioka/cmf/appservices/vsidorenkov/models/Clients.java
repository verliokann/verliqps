package ru.verlioka.cmf.appservices.vsidorenkov.models;

import javax.persistence.*;

@Entity
@Table( name = "clients" )
public class Clients {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Long id;

    @Column( name = "fio" )
    private String fio;

    @Column( name = "phone" )
    private String phone;

    @Column( name = "address" )
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

        Clients clients = (Clients) o;

        if (getId() != null ? !getId().equals(clients.getId()) : clients.getId() != null) return false;
        if (getFio() != null ? !getFio().equals(clients.getFio()) : clients.getFio() != null) return false;
        if (getPhone() != null ? !getPhone().equals(clients.getPhone()) : clients.getPhone() != null) return false;
        return getAddress() != null ? getAddress().equals(clients.getAddress()) : clients.getAddress() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getFio() != null ? getFio().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

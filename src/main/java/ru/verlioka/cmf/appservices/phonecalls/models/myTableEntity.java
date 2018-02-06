package ru.verlioka.cmf.appservices.phonecalls.models;

import javax.persistence.*;


@Entity
@Table(name = "call")


public class myTableEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @Column( name = "phonenumber" )
    private String phoneNumber;

    @ManyToOne
    @JoinColumn( name = "cityid" )
    private cityEntity city;

    @ManyToOne
    @JoinColumn( name = "typeid" )
    private callTypeEntity type;

    @Column( name = "length" )
    private Long length;

    @Column( name = "calldate" )
    private String callDate;

    @Column( name = "calltime" )
    private String callTime;

    @Override
    public String toString() {
        return "myTableEntity{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city=" + city +
                ", type=" + type +
                ", length=" + length +
                ", callDate='" + callDate + '\'' +
                ", callTime='" + callTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        myTableEntity that = (myTableEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        if (callDate != null ? !callDate.equals(that.callDate) : that.callDate != null) return false;
        return callTime != null ? callTime.equals(that.callTime) : that.callTime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (callDate != null ? callDate.hashCode() : 0);
        result = 31 * result + (callTime != null ? callTime.hashCode() : 0);
        return result;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public cityEntity getCity() {
        return city;
    }

    public void setCity(cityEntity city) {
        this.city = city;
    }

    public callTypeEntity getType() {
        return type;
    }

    public void setType(callTypeEntity type) {
        this.type = type;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public String getCallDate() {
        return callDate;
    }

    public void setCallDate(String callDate) {
        this.callDate = callDate;
    }

    public String getCallTime() {
        return callTime;
    }

    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }
}

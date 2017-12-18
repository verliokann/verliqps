package ru.verlioka.cmf.appservices.Am2200.models;

import javax.persistence.*;

@Entity
@Table(name = "hotels")
public class HotelsEntity {

    @Id
    @Column(name = "id_hotel", unique = true)
    private Integer Id_Hotel;

    @Column(name = "hotelname")
    private String HotelName;

    @Column(name = "typehotel")
    private String TypeHotel;

    public Integer getId_Hotel() {
        return Id_Hotel;
    }

    public void setId_Hotel(Integer id_Hotel) {
        Id_Hotel = id_Hotel;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public String getTypeHotel() {
        return TypeHotel;
    }

    public void setTypeHotel(String typeHotel) {
        TypeHotel = typeHotel;
    }
}

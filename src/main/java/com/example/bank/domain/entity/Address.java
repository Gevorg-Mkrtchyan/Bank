package com.example.bank.domain.entity;

import com.example.bank.domain.enumType.Country;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    private Country country;
    @Column(name = "city", length = 25)
    @Min(3)
    private String city;
    @Column(name = "street", length = 35)
    @Min(3)
    private String street;
    @Column(name = "building", length = 15)
    @Min(1)
    private String building;
    @Column(name = "home", length = 15)
    private String home;
    @Column(name = "zip", length = 15)
    @Min(1)
    private String zip;
    @OneToMany(mappedBy = "address")
    private Set<CardHolder> cardHolders;

    public Address(String city, String street, String building, String home, String zip) {
        this.city = city;
        this.street = street;
        this.building = building;
        this.home = home;
        this.zip = zip;
    }

    public Address() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}


package model;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name="Profile_Id")
    private Profile profile;
    private String country;
    private String region;
    private String city;
    private String street;
    private Byte house_number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile_Id(Profile profile) {
        this.profile = profile;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public Byte getHouse_number() {
        return house_number;
    }

    public void setHouse_number(Byte house_number) {
        this.house_number = house_number;
    }
}

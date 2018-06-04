package dto;

import domain.Person;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Sjoerd
 */
public class AddressDTO implements Serializable {

    private Long id;
    private String streetName;
    private String streetNumber;    //Note a streetnumber can be a non numeric value (e.g. 12B)
    private String zipCode;
    private String city;
    private String country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AddressDTO() {
    }

    public AddressDTO(Long id, String streetName, String streetNumber, String zipCode, String city, String country) {
        this.id = id;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }
}

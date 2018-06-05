package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;

/**
 *
 * @author Sjoerd
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Address.findAddress",
                query = "SELECT a FROM Address a " +
                        "WHERE streetName = :streetName " +
                        "AND streetNumber = :streetNumber" +
                        "AND zipCode = :zipCode" +
                        "AND city = :city" +
                        "AND country = :country "),
        @NamedQuery(name = "Address.getAll",
                query = "SELECT a FROM Address a ")
})
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String streetName;
    private String streetNumber;    //Note a streetnumber can be a non numeric value (e.g. 12B)
    private String zipCode;
    private String city;
    private String country;

    @OneToMany(
            mappedBy = "address",
            fetch = FetchType.LAZY
    )    private final List<Person> persons = new ArrayList<>();


    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">

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

    public List<Person> getPersons() {
        return persons;
    }

    public boolean addPerson(Person person){
        if(!persons.contains(person)){
            persons.add(person);
            return true;
        }

        return false;
    }

    public boolean removePerson(Person person){
        if(persons.contains(person)){
            persons.remove(person);
            return true;
        }

        return false;
    }

    public Address() {
    }

    public Address(Long id, String streetName, String streetNumber, String zipCode, String city, String country) {
        this.id = id;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    // </editor-fold>
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Address)) {
            return false;
        }
        Address otherAddress = (Address) obj;
        if (this.id == null || otherAddress.id == null) {
            return false;
        }
        return this.id.equals(otherAddress.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.streetName);
        hash = 79 * hash + Objects.hashCode(this.streetNumber);
        hash = 79 * hash + Objects.hashCode(this.zipCode);
        hash = 79 * hash + Objects.hashCode(this.city);
        hash = 79 * hash + Objects.hashCode(this.country);
        return hash;
    }
}

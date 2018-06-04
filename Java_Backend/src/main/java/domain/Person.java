package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.REMOVE;

/**
 *
 * @author Sjoerd
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.GetPersonByCar", query = "SELECT p FROM Person p WHERE :vehicle member p.vehicles")
})
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Address address;

    @OneToMany(mappedBy = "owner", cascade = ALL, fetch = FetchType.LAZY)
    private final List<Vehicle> vehicles = new ArrayList<>();

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Vehicle> getVehicles() {
        return Collections.unmodifiableList(vehicles);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
        this.address.addPerson(this);
    }

    public void addVehicle(Vehicle vehicle) {
        if (!this.vehicles.contains(vehicle)) {
            vehicle.setOwner(this);
            this.vehicles.add(vehicle);
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        if (this.vehicles.contains(vehicle)) {
            vehicle.setOwner(null);
            this.vehicles.remove(vehicle);
        }
    }

    // </editor-fold>
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }
        Person otherUser = (Person) obj;
        if (this.id == null || otherUser.id == null) {
            return false;
        }
        return this.id.equals(otherUser.id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.firstName);
        hash = 79 * hash + Objects.hashCode(this.lastName);
        return hash;
    }
}

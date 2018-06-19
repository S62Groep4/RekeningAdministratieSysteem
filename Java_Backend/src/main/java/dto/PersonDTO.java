package dto;

import java.io.Serializable;

/**
 *
 * @author Sjoerd
 */
public class PersonDTO implements Serializable {

    private long id;
    private String firstName;
    private String lastName;
    private String vehiclesUri;
    private String addressUri;


    public PersonDTO() {
    }

    public PersonDTO(long id, String firstName, String lastName, String vehiclesUri, String addressUri) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.vehiclesUri = vehiclesUri;
        this.addressUri= addressUri;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getVehiclesUri() {
        return vehiclesUri;
    }

    public void setVehiclesUri(String vehiclesUri) {
        this.vehiclesUri = vehiclesUri;
    }

    public String getAddressUri() {
        return addressUri;
    }

    public void setAddressUri(String addressUri) {
        this.addressUri = addressUri;
    }
}

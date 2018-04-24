package interfaces;

public interface ITransLocation {

    //Latitude from car tracker created at simulation system.
    Double getLat();

    //Longitude from car tracker created at simulation system.
    Double getLon();

    //Date and time of this TransLocation.
    String getDateTime();

    //Serial number of the car tracker, used in the government system to find the hashed license plate and owner.
    String getSerialNumber();

    //Country where this TransLocation is driven at.
    String getCountryCode();
}

package dto;

import java.io.Serializable;

/**
 *
 * @author Teun
 */
public class TransLocationDTO implements Serializable {

    private final String lat;
    private final String lon;
    private final String dateTime;
    private final String serialNumber;
    private final String countryCode;

    public TransLocationDTO(String lat, String lon, String dateTime, String serialNumber, String countryCode) {
        this.lat = lat;
        this.lon = lon;
        this.dateTime = dateTime;
        this.serialNumber = serialNumber;
        this.countryCode = countryCode;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }
}

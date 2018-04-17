package dto;

import java.io.Serializable;

/**
 *
 * @author Teun
 */
public class TransLocationDTO implements Serializable {

    private String lat;
    private String lon;
    private String dateTime;
    private String serialNumber;
    private String countryCode;

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

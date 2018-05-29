package dto;

import java.io.Serializable;

/**
 *
 * @author Teun
 */
public class TransLocationDTO implements Serializable {

    private Double lat;
    private Double lon;
    private String dateTime;
    private String carTrackerId;
    private String countryCode;

    public TransLocationDTO() {
    }

    public TransLocationDTO(Double lat, Double lon, String dateTime, String serialNumber, String countryCode) {
        this.lat = lat;
        this.lon = lon;
        this.dateTime = dateTime;
        this.carTrackerId = serialNumber;
        this.countryCode = countryCode;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setCarTrackerId(String carTrackerId) {
        this.carTrackerId = carTrackerId;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getCarTrackerId() {
        return carTrackerId;
    }

    public String getCountryCode() {
        return countryCode;
    }
}

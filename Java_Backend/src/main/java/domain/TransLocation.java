package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Teun
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "TransLocation.findAll", query = "SELECT t FROM TransLocation t")
    ,@NamedQuery(name = "TransLocation.findBySerialNumber", query = "SELECT t FROM TransLocation t WHERE t.serialNumber = :serialNumber")
    ,@NamedQuery(name = "TransLocation.findByJourneyId", query = "SELECT t FROM TransLocation t WHERE t.journeyId = :journeyId")})
public class TransLocation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Double lat;
    private Double lon;
    private String dateTime;
    private String serialNumber;
    private String countryCode;
    private int journeyId;

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    public int getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(int journeyId) {
        this.journeyId = journeyId;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    // </editor-fold>

    public TransLocation() {
    }

    public TransLocation(Double lat, Double lon, String serialNumber, String countryCode, int journeyId) {
        this.lat = lat;
        this.lon = lon;
        this.dateTime = new Date(System.currentTimeMillis()).toString();
        this.serialNumber = serialNumber;
        this.countryCode = countryCode;
        this.journeyId = journeyId;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TransLocation)) {
            return false;
        }
        TransLocation otherUser = (TransLocation) obj;
        if (this == null) {
            return false;
        }
        return this.id.equals(otherUser.id);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.lat);
        hash = 53 * hash + Objects.hashCode(this.lon);
        hash = 53 * hash + Objects.hashCode(this.dateTime);
        hash = 53 * hash + Objects.hashCode(this.serialNumber);
        hash = 53 * hash + Objects.hashCode(this.countryCode);
        return hash;
    }
}

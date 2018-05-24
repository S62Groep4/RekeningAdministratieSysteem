package domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    ,@NamedQuery(name = "TransLocation.findByJourneyId", query = "SELECT t FROM TransLocation t WHERE t.journey.id = :journeyId")})
public class TransLocation implements Serializable {

    private static final DateFormat DF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Double lat;
    private Double lon;
    private String dateTime;
    private String serialNumber;
    private String countryCode;
    @ManyToOne
    private Journey journey;

    // <editor-fold desc="Getters and Setters" defaultstate="collapsed">
    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
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

    public TransLocation(Double lat, Double lon, String serialNumber, String countryCode) {
        this.lat = lat;
        this.lon = lon;
        this.dateTime = DF.format(new Date());
        this.serialNumber = serialNumber;
        this.countryCode = countryCode;
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
        //hash = 59 * hash + Objects.hashCode(this.lat);
        //hash = 59 * hash + Objects.hashCode(this.lon);
        //hash = 59 * hash + Objects.hashCode(this.dateTime);
        //hash = 59 * hash + Objects.hashCode(this.serialNumber);
        //hash = 59 * hash + Objects.hashCode(this.countryCode);
        return hash;
    }
}

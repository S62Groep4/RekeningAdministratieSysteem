package dto;

import java.io.Serializable;

/**
 *
 * @author Teun
 */
public class RoadDTO implements Serializable {

    private Long id;
    private String shortName;
    private String longName;
    private Double rate;

    public RoadDTO() {
    }

    public RoadDTO(Long id, String shortName, String longName, Double rate) {
        this.id = id;
        this.shortName = shortName;
        this.longName = longName;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}

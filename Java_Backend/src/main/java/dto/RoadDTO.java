package dto;

import java.io.Serializable;

/**
 *
 * @author Teun
 */
public class RoadDTO implements Serializable {

    private Long id;
    private String name;
    private Double rate;

    public RoadDTO() {
    }

    public RoadDTO(Long id, String name, Double rate) {
        this.id = id;
        this.name = name;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}

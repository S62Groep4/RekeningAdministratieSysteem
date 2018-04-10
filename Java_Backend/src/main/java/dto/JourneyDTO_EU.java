package dto;

import java.io.Serializable;

/**
 *
 * @author Teun
 */
public class JourneyDTO_EU implements Serializable {

    private Long id;
    private String translocationUrl;
    private int translocations;

    public JourneyDTO_EU() {
    }

    public JourneyDTO_EU(Long id, String translocationUrl, int translocations) {
        this.id = id;
        this.translocationUrl = translocationUrl;
        this.translocations = translocations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTranslocationUrl() {
        return translocationUrl;
    }

    public void setTranslocationUrl(String translocationUrl) {
        this.translocationUrl = translocationUrl;
    }

    public int getTranslocations() {
        return translocations;
    }

    public void setTranslocations(int translocations) {
        this.translocations = translocations;
    }

}

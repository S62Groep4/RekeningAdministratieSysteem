package dto;

import java.io.Serializable;

/**
 *
 * @author Teun
 */
public class JourneyDTO implements Serializable {

    private Long id;
    private String translocationUri;

    public JourneyDTO() {
    }

    public JourneyDTO(Long id, String translocationUri) {
        this.id = id;
        this.translocationUri = translocationUri;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTranslocationUri() {
        return translocationUri;
    }

    public void setTranslocationUri(String translocationUri) {
        this.translocationUri = translocationUri;
    }
}

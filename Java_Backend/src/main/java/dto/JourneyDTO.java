package dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Teun
 */
public class JourneyDTO implements Serializable {

    private List<TransLocationDTO> translocationDtos;

    public JourneyDTO() {
    }

    public JourneyDTO(List<TransLocationDTO> translocationDtos) {
        this.translocationDtos = translocationDtos;
    }

    public List<TransLocationDTO> getTranslocationDtos() {
        return Collections.unmodifiableList(translocationDtos);
    }

    public void setTranslocationDtos(List<TransLocationDTO> translocationDtos) {
        this.translocationDtos = translocationDtos;
    }

}

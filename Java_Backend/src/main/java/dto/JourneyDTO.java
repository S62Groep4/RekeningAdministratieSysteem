package dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Teun
 */
public class JourneyDTO implements Serializable {

    private final Long id;
    private final List<TransLocationDTO> translocationDtos;

    public JourneyDTO(Long id, List<TransLocationDTO> translocationDtos) {
        this.id = id;
        this.translocationDtos = translocationDtos;
    }

    public Long getId() {
        return id;
    }

    public List<TransLocationDTO> getTranslocationDtos() {
        return Collections.unmodifiableList(translocationDtos);
    }
}

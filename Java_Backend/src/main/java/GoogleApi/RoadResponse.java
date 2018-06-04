package GoogleApi;

/**
 *
 * @author Teun
 */
public class RoadResponse {

    private final String identifier;
    private final SnappedPoint[] snappedPoints;

    public RoadResponse(String identifier, SnappedPoint[] snappedPoints) {
        this.identifier = identifier;
        this.snappedPoints = snappedPoints;
    }

    public String getIdentifier() {
        return identifier;
    }

    public SnappedPoint[] getSnappedPoints() {
        return snappedPoints;
    }
}

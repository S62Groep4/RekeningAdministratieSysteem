package GoogleApi;

/**
 *
 * @author Teun
 */
public class SnappedPoint {

    private final Location location;
    private final String placeId;
    private final int originalIndex;

    public Location getLocation() {
        return location;
    }

    public int getOriginalIndex() {
        return originalIndex;
    }

    public String getPlaceId() {
        return placeId;
    }

    public SnappedPoint(Location location, int originalIndex, String placeId) {
        this.location = location;
        this.originalIndex = originalIndex;
        this.placeId = placeId;
    }

    @Override
    public String toString() {
        return "SnappedPoint{" + "location=" + location + ", placeId=" + placeId + ", originalIndex=" + originalIndex + '}';
    }
}

package GoogleApi;

/**
 *
 * @author Teun
 */
public class PlaceResponse {

    private final String long_name;
    private final String short_name;

    public PlaceResponse(String long_name, String short_name) {
        this.long_name = long_name;
        this.short_name = short_name;
    }

    public String getLong_name() {
        return long_name;
    }

    public String getShort_name() {
        return short_name;
    }
}

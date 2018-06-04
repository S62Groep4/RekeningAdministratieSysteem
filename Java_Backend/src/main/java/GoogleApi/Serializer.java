package GoogleApi;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 *
 * @author Teun
 */
public class Serializer {

    private static final Gson GSON = new Gson();

    public static RoadResponse JsonToRoadApiResponse(String json) {
        return GSON.fromJson(json, RoadResponse.class);
    }

    public static PlaceResponse JsonToPlacesApiResponse(String json) throws Exception {
        JsonObject object = getJsonObjectFromString(json);
        object = object.getAsJsonObject("result");
        JsonArray array = object.getAsJsonArray("address_components");
        object = array.get(0).getAsJsonObject();

        String longName = object.get("long_name").getAsString();
        String shortName = object.get("short_name").getAsString();

        return new PlaceResponse(longName, shortName);
    }

    private static JsonObject getJsonObjectFromString(String json) throws Exception {
        JsonElement element = GSON.fromJson(json, JsonElement.class);
        JsonObject object = element.getAsJsonObject();
        String responseStatus = object.get("status").getAsString();

        if (responseStatus.equals("OK")) {
            return object;
        } else {
            throw new Exception("Google Api Response Status : " + responseStatus);
        }
    }
}

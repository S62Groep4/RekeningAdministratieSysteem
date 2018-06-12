package GoogleApi;

import domain.TransLocation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author Teun
 */
public class NearestRoads {

    //https://developers.google.com/maps/documentation/roads/nearest
    private static final String URL = "https://roads.googleapis.com/v1/nearestRoads?points=%s&key=%s";
    private static final String APIKEY = "AIzaSyDOXFVIhlU_vXNSM_4GFuNBigk_XMTFOdo";

    public static Map<TransLocation, SnappedPoint> CoordinatesToPlaceIds(List<TransLocation> transLocations) throws IOException {
        Map<TransLocation, SnappedPoint> points = new HashMap();

        for (int i = 0; i < transLocations.size(); i += 100) {
            List<TransLocation> subList = transLocations.subList(i, Math.min(transLocations.size(), i + 100));
            String locations = transLocationsToString(subList);
            String fullUrl = String.format(URL, URLEncoder.encode(locations, StandardCharsets.UTF_8.toString()), APIKEY);
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(fullUrl);
            HttpResponse response = httpClient.execute(request);
            System.out.println("Roads Api Response Code : " + response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            SnappedPoint[] sublist2 = Serializer.JsonToRoadApiResponse(result.toString()).getSnappedPoints();
            for (SnappedPoint apiPointFound : sublist2) {
                points.put(subList.get(apiPointFound.getOriginalIndex()), apiPointFound);
            }
        }
        return points;
    }

    private static String transLocationsToString(List<TransLocation> transLocations) {
        StringBuilder sb = new StringBuilder();
        for (TransLocation tl : transLocations) {
            sb.append(tl.getLat());
            sb.append(",");
            sb.append(tl.getLon());
            sb.append("|");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}

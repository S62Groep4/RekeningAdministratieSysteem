package GoogleApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author Teun
 */
public class RoadNames {

    //https://developers.google.com/places/web-service/details
    private static final String URL = "https://maps.googleapis.com/maps/api/place/details/json?placeid=%s&key=%s";
    private static final String APIKEY = "AIzaSyDOXFVIhlU_vXNSM_4GFuNBigk_XMTFOdo";

    public static PlaceResponse PlaceIdToRoadName(String placeId) throws IOException, Exception {
        String fullUrl = String.format(URL, URLEncoder.encode(placeId, StandardCharsets.UTF_8.toString()), APIKEY);
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(fullUrl);
        HttpResponse response = httpClient.execute(request);
        System.out.println("Places Api Response Code : " + response.getStatusLine().getStatusCode());
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.UTF_8));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return Serializer.JsonToPlacesApiResponse(result.toString());
    }
}

package service;

import com.google.gson.Gson;
import dao.JourneyDAO;
import domain.Journey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import static org.apache.http.HttpHeaders.USER_AGENT;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author Teun
 */
@Stateless
public class JourneyService {

    @Inject
    JourneyDAO journeyDao;

    private static final Logger LOGGER = Logger.getLogger(JourneyService.class.getName());

    public JourneyService() {
    }

    public Journey getJourney(Long id) throws PersistenceException {
        try {
            return journeyDao.getJourney(id);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getJourney operation; {0}", pe.getMessage());
            return null;
        }
    }

    public List<Journey> getAllJourneys() throws PersistenceException {
        try {
            return journeyDao.getAllJourneys();
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing getAllJourneys operation; {0}", pe.getMessage());
            return null;
        }
    }

    public Journey updateJourney(Journey journey) throws PersistenceException {
        try {
            return journeyDao.updateJourney(journey);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing updateJourney operation; {0}", pe.getMessage());
            return null;
        }
    }

    public void removeJourney(Long id) throws PersistenceException {
        try {
            journeyDao.removeJourney(id);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing removeJourney operation; {0}", pe.getMessage());
        }
    }

    public Journey insertJourney(Journey journey) throws PersistenceException {
        try {
            return journeyDao.insertJourney(journey);
        } catch (PersistenceException pe) {
            LOGGER.log(Level.FINE, "ERROR while performing insertJourney operation; {0}", pe.getMessage());
            return null;
        }
    }

    public void updateJourneysFromRegistration() throws IOException {
        String url = "http://192.168.24.91:8383/RegistratieSysteem/api/journeys";

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        // add request header
        request.addHeader("User-Agent", USER_AGENT);
        HttpResponse response = client.execute(request);

        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        Journey[] journeys = new Gson().fromJson(result.toString(), Journey[].class);
        List<Journey> journeyslist = Arrays.asList(journeys);
        for (Journey j : journeyslist) {
            insertJourney(j);
        }
    }
}

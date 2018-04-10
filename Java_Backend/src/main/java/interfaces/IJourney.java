package interfaces;

import java.util.List;

public interface IJourney {

    //List of all locations of this journey:
    //The simulation system sends a TransLocation every minute.
    //When a Cartracker is at the same spot for 15 minutes the registration system creates 1 IJourney object with all the TransLocations.
    List<ITransLocation> getTransLocations();
}

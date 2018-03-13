package domain;

import java.util.List;

public interface IVehicle {

    //Hashes license plate of the car, used to find the owner at the government system.
    String getHashedLicensePlate();

    //List of all journeys this car made.
    List<IJourney> getJourneys();

    //List of all sub invoices this car made.
    List<ISubInvoice> getSubInvoices();
}

package service;

import domain.Journey;
import domain.SubInvoice;
import domain.TransLocation;
import domain.Vehicle;
import dto.eu.JourneyDTO_EU;
import dto.eu.SubInvoiceDTO_EU;
import dto.eu.TransLocationDTO_EU;
import dto.eu.VehicleDTO_EU;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import static util.Dto_EUToDomain.*;

/**
 *
 * @author Teun
 */
@Startup
@Singleton
public class Init {

    @Inject
    VehicleService vehicleService;

    @Inject
    TransLocationService transLocationService;

    @Inject
    SubInvoiceService subInvoiceService;

    @PostConstruct
    public void init() {

        //|||||||||||||||||||||||||||||||||||||||||
        //||     PERSISTING EU_DTO OBJECTS       ||
        //|||||||||||||||||||||||||||||||||||||||||
        List<JourneyDTO_EU> journeys = new ArrayList();
        journeys.add(new JourneyDTO_EU(1L, "translocation/1", 0));
        journeys.add(new JourneyDTO_EU(2L, "translocation/2", 0));

        List<TransLocationDTO_EU> locations = new ArrayList();
        locations.add(new TransLocationDTO_EU(1L, 51.855305, 9.623518, new Date().toString(), "654161", "31"));
        locations.add(new TransLocationDTO_EU(2L, 51.735719, 9.579573, new Date().toString(), "654162", "31"));
        locations.add(new TransLocationDTO_EU(3L, 51.626728, 9.689436, new Date().toString(), "654163", "31"));
        locations.add(new TransLocationDTO_EU(4L, 48.087453, 11.535139, new Date().toString(), "188654", "31"));
        locations.add(new TransLocationDTO_EU(5L, 48.058089, 11.359358, new Date().toString(), "188655", "31"));
        locations.add(new TransLocationDTO_EU(6L, 48.014012, 11.139631, new Date().toString(), "188656", "31"));
        locations.add(new TransLocationDTO_EU(7L, 48.028709, 10.985823, new Date().toString(), "188657", "31"));

        List<VehicleDTO_EU> vehicles = new ArrayList();
        vehicles.add(new VehicleDTO_EU(new String(Base64.getEncoder().encode("68JFSF".getBytes())), "journeys/1", 0, "invoice/1", 0));
        vehicles.add(new VehicleDTO_EU(new String(Base64.getEncoder().encode("54HSHS".getBytes())), "journeys/2", 0, "invoice/2", 0));

        List<SubInvoiceDTO_EU> invoices = new ArrayList();
        invoices.add(new SubInvoiceDTO_EU("1", "31", false, new Date().toString(), 165.00));
        invoices.add(new SubInvoiceDTO_EU("2", "31", false, new Date().toString(), 486.00));

        List<SubInvoice> domainInvoices = SUBINVOICE_EU_DTO_TO_DOMAIN(invoices);
        List<TransLocation> domainLocations = TRANSLOCATION_EU_DTO_TO_DOMAIN(locations);
        
        List<Vehicle> domainVehicles = VEHICLE_EU_DTO_TO_DOMAIN(vehicles);
        List<Journey> domainJourneys = JOURNEY_EU_DTO_TO_DOMAIN(journeys);

        /*
        //|||||||||||||||||||||||||||||||||||||||||
        //||     PERSISTING DOMAIN OBJECTS       ||
        //|||||||||||||||||||||||||||||||||||||||||
        int journey1 = 1;
        int journey2 = 2;
        TransLocation loc1 = new TransLocation(51.855305, 9.623518, "654161", "31",journey1);
        TransLocation loc2 = new TransLocation(51.735719, 9.579573, "654162", "31",journey1);
        TransLocation loc3 = new TransLocation(51.626728, 9.689436, "654163", "31",journey1);
        TransLocation loc4 = new TransLocation(48.087453, 11.535139, "188654", "31",journey2);
        TransLocation loc5 = new TransLocation(48.058089, 11.359358, "188655", "31",journey2);
        TransLocation loc6 = new TransLocation(48.014012, 11.139631, "188656", "31",journey2);
        TransLocation loc7 = new TransLocation(48.028709, 10.985823, "188657", "31",journey2);

        Vehicle veh1 = new Vehicle();
        veh1.setUnHashedLicencePlate("68JFSF");
        veh1.addJourney(journey1);

        Vehicle veh2 = new Vehicle();
        veh2.setUnHashedLicencePlate("54HSHS");
        veh2.addJourney(journey2);

        SubInvoice inv1 = new SubInvoice("1", "31", 165.00);
        veh1.addInvoice(inv1);

        SubInvoice inv2 = new SubInvoice("2", "31", 486.00);
        veh2.addInvoice(inv2);

        transLocationService.insertTransLocation(loc1);
        transLocationService.insertTransLocation(loc2);
        transLocationService.insertTransLocation(loc3);
        transLocationService.insertTransLocation(loc4);
        transLocationService.insertTransLocation(loc5);
        transLocationService.insertTransLocation(loc6);
        transLocationService.insertTransLocation(loc7);
        
        vehicleService.insertVehicle(veh1);
        vehicleService.insertVehicle(veh2);
        
        subInvoiceService.insertSubInvoice(inv1);
        subInvoiceService.insertSubInvoice(inv2);*/
    }
}

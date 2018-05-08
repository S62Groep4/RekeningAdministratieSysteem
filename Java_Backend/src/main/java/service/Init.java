package service;

import domain.Journey;
import domain.Road;
import domain.SubInvoice;
import domain.TransLocation;
import domain.Vehicle;
import dto.JourneyDTO;
import dto.SubInvoiceDTO;
import dto.TransLocationDTO;
import dto.VehicleDTO;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import org.mindrot.jbcrypt.BCrypt;
import static util.DtoToDomain.VEHICLE_DTO_TO_DOMAIN;

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

    @Inject
    JourneyService journeyService;

    @Inject
    RoadService roadService;

    @PostConstruct
    public void init() {

        /*
        //|||||||||||||||||||||||||||||||||||||||||
        //||     PERSISTING EU_DTO OBJECTS       ||
        //|||||||||||||||||||||||||||||||||||||||||
        List<TransLocationDTO> loc1 = new ArrayList();
        loc1.add(new TransLocationDTO(51.855305, 9.623518, new Date().toString(), "654161", "31"));
        loc1.add(new TransLocationDTO(51.735719, 9.579573, new Date().toString(), "654162", "31"));
        loc1.add(new TransLocationDTO(51.626728, 9.689436, new Date().toString(), "654163", "31"));
        List<TransLocationDTO> loc2 = new ArrayList();
        loc2.add(new TransLocationDTO(48.087453, 11.535139, new Date().toString(), "188654", "31"));
        loc2.add(new TransLocationDTO(48.058089, 11.359358, new Date().toString(), "188655", "31"));
        loc2.add(new TransLocationDTO(48.014012, 11.139631, new Date().toString(), "188656", "31"));
        loc2.add(new TransLocationDTO(48.028709, 10.985823, new Date().toString(), "188657", "31"));

        List<JourneyDTO> journeys1 = new ArrayList();
        journeys1.add(new JourneyDTO(1L, loc1));
        List<JourneyDTO> journeys2 = new ArrayList();
        journeys2.add(new JourneyDTO(1L, loc2));

        List<SubInvoiceDTO> inv1 = new ArrayList();
        inv1.add(new SubInvoiceDTO(1L, "31", "Open", new Date().toString(), "165.00"));
        List<SubInvoiceDTO> inv2 = new ArrayList();
        inv2.add(new SubInvoiceDTO(1L, "31", "Open", new Date().toString(), "486.00"));

        List<VehicleDTO> vehicles = new ArrayList();
        vehicles.add(new VehicleDTO(new String(Base64.getEncoder().encode(BCrypt.hashpw("68JFSF", BCrypt.gensalt(12)).getBytes())), journeys1, inv1));
        vehicles.add(new VehicleDTO(new String(Base64.getEncoder().encode(BCrypt.hashpw("54HSHS", BCrypt.gensalt(12)).getBytes())), journeys2, inv2));

        List<Vehicle> domainVehicles = VEHICLE_DTO_TO_DOMAIN(vehicles);
         */

 /*
        //|||||||||||||||||||||||||||||||||||||||||
        //||     PERSISTING DOMAIN OBJECTS       ||
        //|||||||||||||||||||||||||||||||||||||||||
         */
        Journey j1 = new Journey(null);
        Journey j2 = new Journey(null);
        TransLocation loc1 = new TransLocation(51.855305, 9.623518, "654161", "31");
        TransLocation loc2 = new TransLocation(51.735719, 9.579573, "654162", "31");
        TransLocation loc3 = new TransLocation(51.626728, 9.689436, "654163", "31");
        TransLocation loc4 = new TransLocation(48.087453, 11.535139, "188654", "31");
        TransLocation loc5 = new TransLocation(48.058089, 11.359358, "188655", "31");
        TransLocation loc6 = new TransLocation(48.014012, 11.139631, "188656", "31");
        TransLocation loc7 = new TransLocation(48.028709, 10.985823, "188657", "31");

        j1.addTransLocation(loc1);
        j1.addTransLocation(loc2);
        j1.addTransLocation(loc3);
        j2.addTransLocation(loc4);
        j2.addTransLocation(loc5);
        j2.addTransLocation(loc6);
        j2.addTransLocation(loc7);

        Vehicle veh1 = new Vehicle();
        veh1.setUnHashedLicencePlate("68JFSF");
        veh1.addJourney(j1);

        Vehicle veh2 = new Vehicle();
        veh2.setUnHashedLicencePlate("54HSHS");
        veh2.addJourney(j2);

        SubInvoice inv1 = new SubInvoice(null, "31", 165.00);
        veh1.addInvoice(inv1);

        SubInvoice inv2 = new SubInvoice(null, "31", 486.00);
        veh2.addInvoice(inv2);

        Road r1 = new Road(null, "A2", 1.2);
        Road r2 = new Road(null, "A50", 1.15);
        Road r3 = new Road(null, "A73", 1.08);
        Road r4 = new Road(null, "A1", 1.18);

        roadService.insertRoad(r1);
        roadService.insertRoad(r2);
        roadService.insertRoad(r3);
        roadService.insertRoad(r4);

        transLocationService.insertTransLocation(loc1);
        transLocationService.insertTransLocation(loc2);
        transLocationService.insertTransLocation(loc3);
        transLocationService.insertTransLocation(loc4);
        transLocationService.insertTransLocation(loc5);
        transLocationService.insertTransLocation(loc6);
        transLocationService.insertTransLocation(loc7);

        journeyService.insertJourney(j1);
        journeyService.insertJourney(j2);

        subInvoiceService.insertSubInvoice(inv1);
        subInvoiceService.insertSubInvoice(inv2);

        vehicleService.insertVehicle(veh1);
        vehicleService.insertVehicle(veh2);
    }
}

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
        loc1.add(new TransLocationDTO(51.855305, 9.623518, new Date().toString(), "654161", "49"));
        loc1.add(new TransLocationDTO(51.735719, 9.579573, new Date().toString(), "654162", "49"));
        loc1.add(new TransLocationDTO(51.626728, 9.689436, new Date().toString(), "654163", "49"));
        List<TransLocationDTO> loc2 = new ArrayList();
        loc2.add(new TransLocationDTO(48.087453, 11.535139, new Date().toString(), "188654", "49"));
        loc2.add(new TransLocationDTO(48.058089, 11.359358, new Date().toString(), "188655", "49"));
        loc2.add(new TransLocationDTO(48.014012, 11.139631, new Date().toString(), "188656", "49"));
        loc2.add(new TransLocationDTO(48.028709, 10.985823, new Date().toString(), "188657", "49"));

        List<JourneyDTO> journeys1 = new ArrayList();
        journeys1.add(new JourneyDTO(1L, loc1));
        List<JourneyDTO> journeys2 = new ArrayList();
        journeys2.add(new JourneyDTO(1L, loc2));

        List<SubInvoiceDTO> inv1 = new ArrayList();
        inv1.add(new SubInvoiceDTO(1L, "49", "Open", new Date().toString(), "165.00"));
        List<SubInvoiceDTO> inv2 = new ArrayList();
        inv2.add(new SubInvoiceDTO(1L, "49", "Open", new Date().toString(), "486.00"));

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
        Journey j3 = new Journey(null);
        Journey j4 = new Journey(null);
        TransLocation loc1 = new TransLocation(51.855305, 9.623518, "654161", "49");
        TransLocation loc2 = new TransLocation(51.735719, 9.579573, "654161", "49");
        TransLocation loc3 = new TransLocation(51.626728, 9.689436, "654161", "49");
        TransLocation loc4 = new TransLocation(48.087453, 11.535139, "188654", "49");
        TransLocation loc5 = new TransLocation(48.058089, 11.359358, "188654", "49");
        TransLocation loc6 = new TransLocation(48.014012, 11.139631, "188654", "49");
        TransLocation loc7 = new TransLocation(48.028709, 10.985823, "188654", "49");
        
        TransLocation loc8 = new TransLocation(48.087453, 11.535139, "188654", "49");
        loc8.setDateTime("2018-04-01 02:00");
        j3.addTransLocation(loc8);
        TransLocation loc9 = new TransLocation(48.058089, 11.359358, "188654", "49");
        loc9.setDateTime("2018-03-28 02:00");
        j3.addTransLocation(loc9);
        TransLocation loc10 = new TransLocation(48.014012, 11.139631, "188654", "49");
        loc10.setDateTime("2018-03-27 02:00");
        j3.addTransLocation(loc10);
        TransLocation loc11 = new TransLocation(48.028709, 10.985823, "188654", "49");
        loc11.setDateTime("2018-04-02 02:00");
        j3.addTransLocation(loc11);
        
        TransLocation loc12 = new TransLocation(48.087453, 11.535139, "188654", "49");
        loc12.setDateTime("2018-05-01 02:00");
        j4.addTransLocation(loc12);
        TransLocation loc13 = new TransLocation(48.058089, 11.359358, "188654", "49");
        loc13.setDateTime("2018-05-03 02:00");
        j4.addTransLocation(loc13);
        TransLocation loc14 = new TransLocation(48.014012, 11.139631, "188654", "49");
        loc14.setDateTime("2018-05-01 02:00");
        j4.addTransLocation(loc14);
        TransLocation loc15 = new TransLocation(48.028709, 10.985823, "188654", "49");
        loc15.setDateTime("2018-05-02 02:00");
        j4.addTransLocation(loc15);

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
        
        
        Vehicle veh3 = new Vehicle();
        veh3.setUnHashedLicencePlate("33DSVL");
        veh3.addJourney(j3);
        veh3.addJourney(j4);

        SubInvoice inv1 = new SubInvoice(null, "49", 165.00, "2018-03");
        veh1.addInvoice(inv1);

        SubInvoice inv2 = new SubInvoice(null, "49", 486.00, "2018-04");
        veh2.addInvoice(inv2);

        Road r1 = new Road(null, "A2", 1.2);
        Road r2 = new Road(null, "A55", 1.1);
        Road r3 = new Road(null, "A50", 1.15);
        Road r4 = new Road(null, "A73", 1.08);
        Road r5 = new Road(null, "A1", 1.18);

        roadService.insertRoad(r1);
        roadService.insertRoad(r2);
        roadService.insertRoad(r3);
        roadService.insertRoad(r4);
        roadService.insertRoad(r5);

        transLocationService.insertTransLocation(loc1);
        transLocationService.insertTransLocation(loc2);
        transLocationService.insertTransLocation(loc3);
        transLocationService.insertTransLocation(loc4);
        transLocationService.insertTransLocation(loc5);
        transLocationService.insertTransLocation(loc6);
        transLocationService.insertTransLocation(loc7);
        transLocationService.insertTransLocation(loc8);
        transLocationService.insertTransLocation(loc9);
        transLocationService.insertTransLocation(loc10);
        transLocationService.insertTransLocation(loc11);
        transLocationService.insertTransLocation(loc12);
        transLocationService.insertTransLocation(loc13);
        transLocationService.insertTransLocation(loc14);

        journeyService.insertJourney(j1);
        journeyService.insertJourney(j2);
        journeyService.insertJourney(j3);
        journeyService.insertJourney(j4);

        subInvoiceService.insertSubInvoice(inv1);
        subInvoiceService.insertSubInvoice(inv2);

        vehicleService.insertVehicle(veh1);
        vehicleService.insertVehicle(veh2);
        vehicleService.insertVehicle(veh3);
    }
}

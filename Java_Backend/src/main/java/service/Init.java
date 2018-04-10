package service;

import domain.Journey;
import domain.SubInvoice;
import domain.TransLocation;
import domain.Vehicle;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import org.mindrot.jbcrypt.BCrypt;

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

    @PostConstruct
    public void init() {
        TransLocation loc1 = new TransLocation(51.855305, 9.623518, "1", "31");
        TransLocation loc2 = new TransLocation(51.735719, 9.579573, "2", "31");
        TransLocation loc3 = new TransLocation(51.626728, 9.689436, "3", "31");
        TransLocation loc4 = new TransLocation(48.087453, 11.535139, "4", "31");
        TransLocation loc5 = new TransLocation(48.058089, 11.359358, "5", "31");
        TransLocation loc6 = new TransLocation(48.014012, 11.139631, "6", "31");
        TransLocation loc7 = new TransLocation(48.028709, 10.985823, "7", "31");

        Journey jou1 = new Journey();
        jou1.addTransLocation(loc1);
        jou1.addTransLocation(loc2);
        jou1.addTransLocation(loc3);

        Journey jou2 = new Journey();
        jou2.addTransLocation(loc4);
        jou2.addTransLocation(loc5);
        jou2.addTransLocation(loc6);
        jou2.addTransLocation(loc7);

        Vehicle veh1 = new Vehicle(BCrypt.hashpw("68JFSF", BCrypt.gensalt(12)));
        veh1.addJourney(jou1);

        Vehicle veh2 = new Vehicle(BCrypt.hashpw("54HSHS", BCrypt.gensalt(12)));
        veh2.addJourney(jou2);

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
        
        journeyService.insertJourney(jou1);
        journeyService.insertJourney(jou2);
        
        vehicleService.insertVehicle(veh1);
        vehicleService.insertVehicle(veh2);
        
        subInvoiceService.insertSubInvoice(inv1);
        subInvoiceService.insertSubInvoice(inv2);
    }
}

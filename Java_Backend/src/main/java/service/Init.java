package service;

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

    @PostConstruct
    public void init() {
        int journey1 = 1;
        int journey2 = 2;
        TransLocation loc1 = new TransLocation(51.855305, 9.623518, "654161", "31",journey1);
        TransLocation loc2 = new TransLocation(51.735719, 9.579573, "654162", "31",journey1);
        TransLocation loc3 = new TransLocation(51.626728, 9.689436, "654163", "31",journey1);
        TransLocation loc4 = new TransLocation(48.087453, 11.535139, "188654", "31",journey2);
        TransLocation loc5 = new TransLocation(48.058089, 11.359358, "188655", "31",journey2);
        TransLocation loc6 = new TransLocation(48.014012, 11.139631, "188656", "31",journey2);
        TransLocation loc7 = new TransLocation(48.028709, 10.985823, "188657", "31",journey2);

        Vehicle veh1 = new Vehicle("68JFSF");
        veh1.addJourney(journey1);

        Vehicle veh2 = new Vehicle("54HSHS");
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
        subInvoiceService.insertSubInvoice(inv2);
    }
}

package service;

import domain.Journey;
import domain.Person;
import domain.Road;
import domain.TransLocation;
import domain.User;
import domain.Vehicle;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

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
    PersonService personService;

    @Inject
    RoadService roadService;

    @Inject
    UserService userService;

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
//        Journey j1 = new Journey(null);
//        TransLocation loc1 = new TransLocation(51.855305, 9.623518, "654161", "49");
//        j1.addTransLocation(loc1);
//        TransLocation loc2 = new TransLocation(51.735719, 9.579573, "654161", "49");
//        j1.addTransLocation(loc2);
//        TransLocation loc3 = new TransLocation(51.626728, 9.689436, "654161", "49");
//        j1.addTransLocation(loc3);
//
//        Journey j2 = new Journey(null);
//        TransLocation loc4 = new TransLocation(48.087453, 11.535139, "188654", "49");
//        j2.addTransLocation(loc4);
//        TransLocation loc5 = new TransLocation(48.058089, 11.359358, "188654", "49");
//        j2.addTransLocation(loc5);
//        TransLocation loc6 = new TransLocation(48.014012, 11.139631, "188654", "49");
//        j2.addTransLocation(loc6);
//        TransLocation loc7 = new TransLocation(48.028709, 10.985823, "188654", "49");
//        j2.addTransLocation(loc7);
//
//        Journey j3 = new Journey(null);
//        TransLocation loc8 = new TransLocation(48.087453, 11.535139, "301214", "49");
//        loc8.setDateTime("2018-04-01T12:00:00+0200");
//        j3.addTransLocation(loc8);
//        TransLocation loc9 = new TransLocation(48.058089, 11.359358, "301214", "49");
//        loc9.setDateTime("2018-04-02T12:00:00+0200");
//        j3.addTransLocation(loc9);
//        TransLocation loc10 = new TransLocation(48.014012, 11.139631, "301214", "49");
//        loc10.setDateTime("2018-04-03T12:00:00+0200");
//        j3.addTransLocation(loc10);
//        TransLocation loc11 = new TransLocation(48.028709, 10.985823, "301214", "49");
//        loc11.setDateTime("2018-04-04T12:00:00+0200");
//        j3.addTransLocation(loc11);
//
//        Journey j4 = new Journey(null);
//        TransLocation loc12 = new TransLocation(52.464471, 13.231006, "301214", "49");
//        loc12.setDateTime("2018-05-01T12:00:00+0200");
//        j4.addTransLocation(loc12);
//        TransLocation loc13 = new TransLocation(52.462072, 13.227734, "301214", "49");
//        loc13.setDateTime("2018-05-02T12:00:00+0200");
//        j4.addTransLocation(loc13);
//        TransLocation loc14 = new TransLocation(52.459052, 13.223861, "301214", "49");
//        loc14.setDateTime("2018-05-03T12:00:00+0200");
//        j4.addTransLocation(loc14);
//        TransLocation loc15 = new TransLocation(52.454332, 13.217960, "301214", "49");
//        loc15.setDateTime("2018-05-04T12:00:00+0200");
//        j4.addTransLocation(loc15);

        Person person1 = new Person("Peter", "Fritssens");
        Person person2 = new Person("Freek", "Jannssen");
        Person person3 = new Person("Robert", "de Graaf");
        Person person4 = new Person("Rickert", "Fruitboom");
        Person person5 = new Person("Rickert", "Fruitboom");
        Person person6 = new Person("Rickert", "Fruitboom");

//        Vehicle veh1 = new Vehicle();
//        veh1.setUnHashedLicencePlate("68JFSF");
//        veh1.setCarTrackerId("654161");
//        veh1.addJourney(j1);
//
//        Vehicle veh2 = new Vehicle();
//        veh2.setUnHashedLicencePlate("54HSHS");
//        veh2.setCarTrackerId("188654L");
//        veh2.addJourney(j2);
//
//        Vehicle veh3 = new Vehicle();
//        veh3.setUnHashedLicencePlate("33DSVL");
//        veh3.setCarTrackerId("301214L");
//        veh3.addJourney(j3);
//        veh3.addJourney(j4);

        //Real ones
        Vehicle veh4 = new Vehicle();
        veh4.setUnHashedLicencePlate("54-XJN-4");
        veh4.setCarTrackerId("c58d5cc9-cb02-4b03-9704-f58079326779");
        veh4.setHashedLicencePlate("$2a$04$NtDNjgrqmXVFpo6qM1CkPet6q0Lf.D1OMjyBJ4EruVhFEYadRbS56");

        Vehicle veh5 = new Vehicle();
        veh5.setUnHashedLicencePlate("63-FXA-6");
        veh5.setCarTrackerId("c6190737-630c-4cbc-8b1d-3a6b8864516f");
        veh5.setHashedLicencePlate("$2a$04$WibjRSBs0tMKUS/TotETReN/ALimELzhWdTz9rA7bNvYxHk6PTQsO");

        Vehicle veh6 = new Vehicle();
        veh6.setUnHashedLicencePlate("73-AHC-5");
        veh6.setCarTrackerId("59620da1-12c5-4ccd-9b29-2ae0cefb0565");
        veh6.setHashedLicencePlate("$2a$04$O0irp2rU9PsU1S/pfdMBquhFwlv.IQY/CZuFv5fBQMUKG3AC2Kk9.");

//        person1.addVehicle(veh1);
//        person2.addVehicle(veh2);
//        person3.addVehicle(veh3);
        person4.addVehicle(veh4);
        person5.addVehicle(veh5);
        person6.addVehicle(veh6);

        Road r1 = new Road("B11", "Wolfratshauser Straße", 1.0);
        Road r2 = new Road("Uslar", "Uslar", 1.0);
        Road r3 = new Road("E51", "Autobahnzubringer Magdeburg/Leipzig", 1.0);
        Road r4 = new Road("A73", "A73", 1.0);
        Road r5 = new Road("A1", "A1", 1.0);

        User user1 = new User("user1", "user1");
        user1.setPerson(person1);
        User user2 = new User("user2", "user2");
        user2.setPerson(person2);
        User user3 = new User("user3", "user3");
        user3.setPerson(person3);
        User user4 = new User("user4", "user4");
        user4.setPerson(person4);
        User user5 = new User("user5", "user5");
        user5.setPerson(person5);
        User user6 = new User("user6", "user6");
        user6.setPerson(person6);

        
        //EU users and persons
        Person finlandPerson = new Person("Finland", "Findland");
        User findlandUser = new User("Finland", "Finland");
        findlandUser.setPerson(finlandPerson);
        Vehicle findlandVehicle = new Vehicle();
        findlandVehicle.setUnHashedLicencePlate("FINLAND");
        findlandVehicle.setCarTrackerId("FI");
        findlandVehicle.setHashedLicencePlate("$2a$04$i26uAaUYSNO9AzAE9aEj6OskWz3dE0barNklQAk8N53EMoH6bMR1.");
        findlandVehicle.setOwner(finlandPerson);
        vehicleService.insertVehicle(findlandVehicle);
        personService.insertPerson(finlandPerson);
        userService.insertUser(findlandUser);
        
        Person nederlandPerson = new Person("Nederland", "Nederland");
        User nederlandUser = new User("Nederland", "Nederland");
        nederlandUser.setPerson(nederlandPerson);
        Vehicle nederlandVehicle = new Vehicle();
        nederlandVehicle.setUnHashedLicencePlate("NEDERLAND");
        nederlandVehicle.setCarTrackerId("NL");
        nederlandVehicle.setHashedLicencePlate("$2a$04$hUdlWgV6NZ9PjTU18ubSqupZP/oQXXtypA/vv9crwc97Q0B7o3jHm");
        nederlandVehicle.setOwner(nederlandPerson);
        vehicleService.insertVehicle(nederlandVehicle);
        personService.insertPerson(nederlandPerson);
        userService.insertUser(nederlandUser);
        
        Person belgiePerson = new Person("Belgie", "Belgie");
        User belgieUser = new User("Belgie", "Belgie");
        belgieUser.setPerson(belgiePerson);
        Vehicle belgieVehicle = new Vehicle();
        belgieVehicle.setUnHashedLicencePlate("BELGIE");
        belgieVehicle.setCarTrackerId("BE");
        belgieVehicle.setHashedLicencePlate("$2a$04$NBGfGjFwCINNnDd37k6JLuCn4HJMm2qJAZ9k.nSGXdJYTutrOX5b2");
        belgieVehicle.setOwner(belgiePerson);
        vehicleService.insertVehicle(belgieVehicle);
        personService.insertPerson(belgiePerson);
        userService.insertUser(belgieUser);
        
        Person italiePerson = new Person("Italie", "Italie");
        User italieUser = new User("Italie", "Italie");
        italieUser.setPerson(italiePerson);
        Vehicle italieVehicle = new Vehicle();
        italieVehicle.setUnHashedLicencePlate("ITALIE");
        italieVehicle.setCarTrackerId("IT");
        italieVehicle.setHashedLicencePlate("$2a$04$RUxa8OnFN2zbeuKDl3zvwuFKdEXPFVhwPqNqjaZ09qd.Q4farrI0G");
        italieVehicle.setOwner(italiePerson);
        vehicleService.insertVehicle(italieVehicle);
        personService.insertPerson(italiePerson);
        userService.insertUser(italieUser);
        
        Person duitslandPerson = new Person("Duitsland", "Duitsland");
        User duitslandUser = new User("Duitsland", "Duitsland");
        duitslandUser.setPerson(duitslandPerson);
        Vehicle duitslandVehicle = new Vehicle();
        duitslandVehicle.setUnHashedLicencePlate("DUITSLAND");
        duitslandVehicle.setCarTrackerId("DE");
        duitslandVehicle.setHashedLicencePlate("$2a$04$.N2XcMv26/BBMjGgnS8VCuA7PHQkb/AGJ7xBhUZGCIJigjmoV72N6");
        duitslandVehicle.setOwner(duitslandPerson);
        vehicleService.insertVehicle(duitslandVehicle);
        personService.insertPerson(duitslandPerson);
        userService.insertUser(duitslandUser);
        //
        
        
        roadService.insertRoad(r1);
        roadService.insertRoad(r2);
        roadService.insertRoad(r3);
        roadService.insertRoad(r4);
        roadService.insertRoad(r5);

//        transLocationService.insertTransLocation(loc1);
//        transLocationService.insertTransLocation(loc2);
//        transLocationService.insertTransLocation(loc3);
//        transLocationService.insertTransLocation(loc4);
//        transLocationService.insertTransLocation(loc5);
//        transLocationService.insertTransLocation(loc6);
//        transLocationService.insertTransLocation(loc7);
//        transLocationService.insertTransLocation(loc8);
//        transLocationService.insertTransLocation(loc9);
//        transLocationService.insertTransLocation(loc10);
//        transLocationService.insertTransLocation(loc11);
//        transLocationService.insertTransLocation(loc12);
//        transLocationService.insertTransLocation(loc13);
//        transLocationService.insertTransLocation(loc14);
//
//        journeyService.insertJourney(j1);
//        journeyService.insertJourney(j2);
//        journeyService.insertJourney(j3);
//        journeyService.insertJourney(j4);
//
//        vehicleService.insertVehicle(veh1);
//        vehicleService.insertVehicle(veh2);
//        vehicleService.insertVehicle(veh3);
        vehicleService.insertVehicle(veh4);
        vehicleService.insertVehicle(veh5);
        vehicleService.insertVehicle(veh6);

        personService.insertPerson(person1);
        personService.insertPerson(person2);
        personService.insertPerson(person3);
        personService.insertPerson(person4);
        personService.insertPerson(person5);
        personService.insertPerson(person6);

        userService.insertUser(user1);
        userService.insertUser(user2);
        userService.insertUser(user3);
        userService.insertUser(user4);
        userService.insertUser(user5);
        userService.insertUser(user6);

    }
}

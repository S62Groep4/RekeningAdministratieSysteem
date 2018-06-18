package jms;

import domain.SubInvoice;
import domain.TransLocation;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

//@Singleton
//@Startup
public class RabbitBindingInitializer {

    @Inject
    private TranslocationBinder translocationBinder;

    private static final Logger LOGGER = Logger.getLogger(SubInvoice.class.getName());

    //https://github.com/reinhapa/rabbitmq-cdi


    @PostConstruct
    public void initialize() {
        /**
         * Setup binding for GPS Tracker
         */

        try {
            translocationBinder.configuration()
                    .addHost("192.168.24.99")
                    .setUsername("guest")
                    .setPassword("guest");

            translocationBinder.initialize();
        } catch (IOException e) {
            LOGGER.log(Level.FINE, "ERROR while performing initialize queue; {0}", e.getMessage());
        }
    }



}
package jms;

import domain.TransLocation;
import dto.SubInvoiceDTO;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class ExternalInvoicesListener {

    //https://github.com/reinhapa/rabbitmq-cdi

    private static final Logger LOGGER = Logger.getLogger(TransLocation.class.getName());


    public void reveiveEvent(@Observes SubInvoiceDTO subInvoiceDTO) {

        LOGGER.log(Level.FINE, "New SubInvoice received", subInvoiceDTO);

        //Do Some work

    }
}

package jms;

import com.google.gson.Gson;
import dto.SubInvoiceDTO;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

@Stateless
public class InvoiceProducer {

    private static final String QUEUE_NAME = "rekeningrijden.invoices";
    private static final Gson GSON = new Gson();
    private Gateway gateway;

    public InvoiceProducer() {
        try {
            this.gateway = new Gateway();
            gateway.channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        } catch (IOException | TimeoutException ex) {
            Logger.getLogger(InvoiceProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void send(SubInvoiceDTO subInvoiceDTO) {
        try {
            String subInvoiceString = GSON.toJson(subInvoiceDTO);
            this.gateway.channel.basicPublish("", QUEUE_NAME, null, subInvoiceString.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(InvoiceProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

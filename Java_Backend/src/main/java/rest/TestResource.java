/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import dto.SubInvoiceDTO;
import dto.TransLocationDTO;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

/**
 *
 * @author Sjoerd
 */
@Stateless
@Path("test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {

    private static final Logger LOGGER = Logger.getLogger(TransLocationDTO.class.getName());


    @Inject
    private Event<TransLocationDTO> eventOnes;


    @GET
    public String test() throws IOException, TimeoutException {
        SubInvoiceDTO eventOne = new SubInvoiceDTO();
        eventOne.setCountry("DB");
        eventOne.setPaymentStatus("Betaald");

        sendToMQ(eventOne);
        return "test";
    }



    private final String queueName = "rekeningrijden.invoices";



    private void sendToMQ(SubInvoiceDTO location) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.24.99");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        channel.queueDeclare(queueName, true, false, false, null);

        String message = "test";


        Gson gson = new Gson();

        // 2. Java object to JSON, and assign to a String
        message = gson.toJson(location);



        channel.basicPublish( "", queueName,
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }





}

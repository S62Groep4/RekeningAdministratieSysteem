/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Gateway {
    private ConnectionFactory factory;
    public Connection connection;
    public Channel channel;
    
    public Gateway() throws IOException, TimeoutException {
        factory = new ConnectionFactory();
        factory.setHost("192.168.24.99");
        factory.setUsername("guest");
        factory.setPassword("guest");
        connection = factory.newConnection();
        channel = connection.createChannel();
    }
}

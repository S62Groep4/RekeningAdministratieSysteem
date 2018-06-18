package jms;

import com.google.gson.Gson;
import domain.SubInvoice;
import dto.SubInvoiceDTO;
import net.reini.rabbitmq.cdi.*;

import javax.enterprise.context.Dependent;
import java.util.logging.Logger;

//https://github.com/reinhapa/rabbitmq-cdi


@Dependent
public class TranslocationBinder extends EventBinder {
    private final String queueName = "rekeningrijden.invoices";

    private static final Logger LOGGER = Logger.getLogger(SubInvoice.class.getName());


    @Override
    protected void bindEvents() {


        bind(SubInvoiceDTO.class)
                .toQueue(this.queueName)
                .withDecoder(new Decoder<SubInvoiceDTO>() {
                    @Override
                    public SubInvoiceDTO decode(byte[] bytes) throws DecodeException {
                        String data = new String(bytes);

                        Gson gson = new Gson();
                        SubInvoiceDTO subInvoiceDTO = gson.fromJson(data, SubInvoiceDTO.class);
                        return subInvoiceDTO;
                    }

                    @Override
                    public boolean willDecode(String s) {
                        return s.equals("text/plain");
                    }
                }).autoAck();
    }
}



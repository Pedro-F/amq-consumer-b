package consumer_b;

import javax.jms.Connection;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@RestController
@EnableAutoConfiguration
@EnableJms
/**
 * This class listen to messages on a JBoss EAP AMQ Queue
 * @author pedro.alonso.garcia
 *
 */


public class consumer implements ExceptionListener {
	//Variables Globales
	Connection conn = null;
	Session session = null;
	MessageConsumer consumidor = null;
	
	
	@JmsListener(destination = "Consumer.B.VirtualTopic.AMQTopic")
	public void receiveQueue(String text) {
		System.out.println(text);
		
		Evento myEvento;
        
        Gson gson = new GsonBuilder().create();
        myEvento = gson.fromJson(text, Evento.class);
	}
	
	@RequestMapping("/")
	String home() {
		
		return "<strong>Consumer</strong> <br>Recibiendo mensajes</br>";
	}

	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(consumer.class, args);
        
    }
 
    public synchronized void onException(JMSException ex) {
        System.out.println("JMS Exception occured.  Shutting down client.");
    }
}
	
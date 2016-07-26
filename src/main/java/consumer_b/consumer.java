package consumer_b;

import javax.jms.Connection;
import javax.jms.Destination;
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
	
	
	@JmsListener(destination = "Consumer.B.VirtualTopic.PruebaAlex")
	public void receiveQueue(String text) {
		System.out.println(text);
		
		Evento myEvento;
        
        Gson gson = new GsonBuilder().create();
        myEvento = gson.fromJson(text, Evento.class);
	}
	
	@RequestMapping("/")
	String home() {
		
		try {
			if (conn == null){
				init();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "<strong>Consumer</strong> <br>Recibiendo mensajes</br>";
	}

	private void init() {
		
		conn = ConsumerConnection.getConnection();
		
		try{
			// Create a Session
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue("Consumer.B.VirtualTopic.PruebaAlex");

            // Create a MessageProducer from the Session to the Topic or Queue
            consumidor = session.createConsumer(destination);
            
		
		 }
	    catch (Exception e) {
	        System.out.println("Init Caught: " + e);
	        e.printStackTrace();
 	    }
	}
    public static void main(String[] args) throws Exception {
        SpringApplication.run(consumer.class, args);
        
    }
 
    public synchronized void onException(JMSException ex) {
        System.out.println("JMS Exception occured.  Shutting down client.");
    }
}
	
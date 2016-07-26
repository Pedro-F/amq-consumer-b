package consumer_b;

import javax.jms.Connection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * This class has a static method "getConnection" that connects to an ActiveMQ Queue 
 * @author pedro.alonso.garcia
 *
 */
public class ConsumerConnection{
	
	public static Connection getConnection(){
		Connection connection = null;
		try {
            
        	// Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://cola-amq-amq-tcp:61616");

            // Create a Connection
            connection = connectionFactory.createConnection("user","password");
            connection.start();
            
            
		}
        catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
		return connection;
    }
	
}

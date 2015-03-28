import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class Send {
	private final static String QUEUE_NAME = "hello";
	private final static String HOST = "172.16.3.10";
	private final static String MESSAGE = "Mike";
	private final static int PORT = 5672;
	private final static String UNAME = "admin";
	private final static String PWORD = "admin";
	
	public static void main(String[] argv) throws java.io.IOException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setPort(PORT);
		factory.setUsername(UNAME);
		factory.setPassword(PWORD);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		boolean durable = true;
		channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
		String message = MESSAGE;
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");
		
		channel.close();
		connection.close();
	}
}

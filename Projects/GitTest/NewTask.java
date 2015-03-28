import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

public class NewTask {
	private final static String QUEUE_NAME = "task_queue";
	private final static String HOST = "172.16.3.10";
	private final static String MESSAGE = "Mike..";
	private final static int PORT = 5672;
	private final static String UNAME = "admin";
	private final static String PWORD = "admin";

	private static String getMessage(String[] strings){
		if (strings.length < 1)
			return MESSAGE;
		return joinStrings(strings, " ");
	}

	private static String joinStrings(String[] strings, String delimiter){
		int length = strings.length;

		if(length == 0)
			return "";

		StringBuilder words = new StringBuilder(strings[0]);
		for(int i = 1; i < length; i++){
			words.append(delimiter).append(strings[i]);
		}

		return words.toString();
	}

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
		String message = getMessage(argv);
		channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");

		channel.close();
		connection.close();
	}
}
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;

public class Recv {

	private final static String QUEUE_NAME = "hello";
	private final static String HOST = "172.16.3.10";
	private final static int PORT = 5672;
	private final static String UNAME = "admin";
	private final static String PWORD = "admin";

	public static void main(String[] argv)
			throws java.io.IOException,
			java.lang.InterruptedException {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setPort(PORT);
		factory.setUsername(UNAME);
		factory.setPassword(PWORD);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		boolean durable = true;
		channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		QueueingConsumer consumer = new QueueingConsumer(channel);
		boolean autoAck = false;
		channel.basicConsume(QUEUE_NAME, autoAck, consumer);

		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println(" [x] Received '" + message + "'");
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		}
	}
}

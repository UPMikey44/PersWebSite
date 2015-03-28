import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;

public class Worker {

	private final static String QUEUE_NAME = "task_queue";
	private final static String HOST = "172.16.3.10";
	private final static int PORT = 5672;
	private final static String UNAME = "admin";
	private final static String PWORD = "admin";

	private static void doWork(String task) throws InterruptedException {
		for(char ch: task.toCharArray())
			if(ch == '.')
				Thread.sleep(1000);
	}
	
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
		
		int prefetchCount = 1;
		channel.basicQos(prefetchCount);

		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, true, consumer);

		while (true) {
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			
			System.out.println(" [x] Received '" + message + "'");
			doWork(message);
			System.out.println(" [x] Done");
		}
	}
}

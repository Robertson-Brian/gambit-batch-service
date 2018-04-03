package com.revature.hydra.messaging;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.revature.hydra.entities.TraineeDTO;
import com.revature.hydra.services.BatchService;

@Service
public class BatchReceiver {
	
	public BatchReceiver() {
		super();
		try {
			this.receiveTrainee();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	
    private static final String TRAINEE_EXCHANGE = "hydra.trainee.exchange";
	private static final Logger log = Logger.getLogger(BatchReceiver.class);
	private ObjectMapper om = new ObjectMapper();
	

	@Autowired
	private BatchService batchService;
	

    public void receiveTrainee() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();

		// This user was created on host machine through the rabbitmq management console
		// (localhost:15672 as of 3/28/2018)
		factory.setUsername("test");
		factory.setPassword("test");
		// Gets the address of the local machine
		// Has not been tested on an EC2  04/02/2018
		//factory.setHost(InetAddress.getLocalHost().getHostAddress());
		factory.setHost("10.226.124.149");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.exchangeDeclare(TRAINEE_EXCHANGE, "fanout");
		String queueName = channel.queueDeclare().getQueue();
		channel.queueBind(queueName, TRAINEE_EXCHANGE, "");

		log.info(" [*] Waiting for messages.");

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				log.info(" [x] Trainee Received '" + message + "'");
				TraineeDTO trainee = om.readValue(message, TraineeDTO.class);
				log.info("[x] Trainee after parse: " + trainee.toString());
				// Checks if the sender receives their own message, which is intended behavior.
				// Prevents service from updating when it receives its own updates
				if (trainee.getSender().equals(InetAddress.getLocalHost().getHostAddress())) {
					log.info("Received own message, as intended.");
				} else {
					/* 
					 * Additional functions would be added here based on what you want to do with the received information
					*/
					if (trainee.getRequestType().equals("PUT")) {
						//batchService.update(trainee.getTrainee());
						log.info("PUT method received");
					}
					if (trainee.getRequestType().equals("POST")) {
						// gets the trainee object from the wrapper object
						batchService.newBatchTrainee(trainee.getTrainee());
						log.info("POST method received");
					}
				}

			}
		};
		channel.basicConsume(queueName, true, consumer);
    	
    	
    }
//        ConnectionFactory factory = new ConnectionFactory();
//		factory.setHost(InetAddress.getLocalHost().getHostAddress());
//        factory.setUsername("test");
//        factory.setPassword("test");
//        Connection connection = factory.newConnection();
//        Channel channel = connection.createChannel();
//
//        channel.queueDeclare(TRAINEE_EXCHANGE, false, false, false, null);
//
//        Consumer consumer = new DefaultConsumer(channel) {
//            @Override
//            public void handleDelivery(String consumerTag,
//                                       Envelope envelope, AMQP.BasicProperties properties,
//                                       byte[] body) throws IOException {
//                String message = new String(body, "UTF-8");
//                System.out.println(" [x] Received '" + message + "'");
//            }
//        };
//        channel.basicConsume(TRAINEE_EXCHANGE, true, consumer);
//    }
}
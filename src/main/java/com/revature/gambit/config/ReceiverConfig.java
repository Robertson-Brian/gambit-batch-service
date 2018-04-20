package com.revature.gambit.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import com.revature.gambit.messaging.Receiver;



/**
 * @author chris
 *	a config for kafka to receive messages form a topic
 */
@Configuration
@EnableKafka
public class ReceiverConfig {
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	
	/**
	 * (pulled from a template some setup needed)
	 * Creates a map for kafka to receive messages 
	 * @return
	 */
	@Bean
	public Map<String, Object> consumerConfigs(){
		
		Map<String,Object> props= new HashMap<>();
		
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "batch");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		return props;
		
		}
	
	
	/**
	 * (pulled from a template)
	 * creates the Factory to take in messages from a kafka server
	 * @return
	 */
	@Bean
	public ConsumerFactory<String,String> consumerFactory(){
		return new DefaultKafkaConsumerFactory<>(consumerConfigs());
		
	}
	
	/**
	 * (pulled from a template)
	 * creates a new instance of a listener so it can receive new messages that are posted to kafka topic 
	 * @return the factory 
	 */
	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> kafkaListenerContainerFactory(){
		
		ConcurrentKafkaListenerContainerFactory<String, String> factory=
				new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		
		
		
		return factory;
		
	}
	
	/**
	 * (should be made inside service)
	 * start an instance of a receiver
	 * @return
	 */
	@Bean
	public Receiver receiver() {
		return new Receiver();
		
	}
	
	

}

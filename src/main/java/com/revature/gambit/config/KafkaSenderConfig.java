package com.revature.gambit.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.revature.gambit.messaging.Sender;



/**
 * @author chris
 *	a Configuration that sets up a kafka sender to be able to send to a kafka server 
 */
@Configuration
public class KafkaSenderConfig {
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	
	/**
	 * (pulled from a template some set up needed)
	 * creates the mapping that is going to be sent to kafka 
	 * @return
	 */
	@Bean
	public Map<String, Object> producerConfigs(){
		
		Map<String, Object> props = new HashMap<>();
		
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		return props;
		
	}
	
	/**
	 * (pulled from a template)
	 * Create factory for creating messages to be sent
	 * @return
	 */
	@Bean
	public ProducerFactory<String, String> producerFactory() {
		
		return new DefaultKafkaProducerFactory<>(producerConfigs());
		
	}
	
	
	/**
	 * (pulled from a template)
	 * @return a template of message going to be sent 
	 */
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		
		return new KafkaTemplate<>(producerFactory());
		
	}
	
	/**
	 * creates the sender functions to be used 
	 * (should have been created in the service)
	 * @return an instance of sender 
	 */
	@Bean
	public Sender sender() {
		
		return new Sender();
		
	}

}
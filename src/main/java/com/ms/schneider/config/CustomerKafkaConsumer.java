package com.ms.schneider.config;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ms.schneider.dto.CustomerDTO;
import com.ms.schneider.entity.AddressData;
import com.ms.schneider.entity.CustomerMongoData;
import com.ms.schneider.repositories.CustomerMongoRepository;

import java.time.Instant;

@Service
@AllArgsConstructor
public class CustomerKafkaConsumer {

	private final CustomerMongoRepository mongoRepository;

	@KafkaListener(topics = "customer-topic", groupId = "customer-group")
	public void consume(CustomerDTO message) {

		CustomerMongoData doc = CustomerMongoData.builder().customerId(message.getCustomerId())
				.firstName(message.getFirstName()).lastName(message.getLastName()).birthDay(message.getBirthDay())
				.birthMonth(message.getBirthMonth()).birthYear(message.getBirthYear()).email(message.getEmail())
				.address(AddressData.builder().street(message.getAddress().getStreet())
						.number(message.getAddress().getNumber()).city(message.getAddress().getCity())
						.state(message.getAddress().getState()).country(message.getAddress().getCountry()).build())
				.receivedAt(Instant.now()).build();

		mongoRepository.save(doc);

		System.out.println("Guardado en Mongo: " + message.getCustomerId());
	}
}

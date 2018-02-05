package com.conferencebooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
public class ConferenceBookingMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceBookingMicroServiceApplication.class, args);
	}
}

package com.conferencebooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class HotelBookingMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingMicroServiceApplication.class, args);
	}
}

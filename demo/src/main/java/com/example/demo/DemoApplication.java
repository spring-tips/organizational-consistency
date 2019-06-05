package com.example.demo;

import lombok.extern.log4j.Log4j2;
import numbers.NumberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

@Log4j2
@Component
class NumberDemo {

	private final NumberService numberService;

	NumberDemo(NumberService numberService) {
		this.numberService = numberService;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void run() {
		int randomNumber = this.numberService.generateRandomNumber();
		log.info("new random number: " + randomNumber);
	}
}

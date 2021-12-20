package com.example.demohazelcastcache;

import com.example.demohazelcastcache.services.PersonServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

@SpringBootTest
class DemoHazelcastCacheApplicationTests {

	@Autowired
	private PersonServices personServices;

	@Test
	void contextLoads() {
	}

	@Test
	public void personTest() {
		Temporal init = LocalDateTime.now();
		personServices.findByName("Furkan").ifPresent(System.out::println);

		//Fİnished Duration
		System.out.println("Finished without cache: " + this.dateTimeDifference(init, LocalDateTime.now(), ChronoUnit.MILLIS)+ " milliseconds");
		init = LocalDateTime.now();
		personServices.findByName("Furkan").ifPresent(System.out::println);
		System.out.println("Finished with cache: " + this.dateTimeDifference(init, LocalDateTime.now(), ChronoUnit.MILLIS)+ " milliseconds");


	}

	//Duration
	private long dateTimeDifference(Temporal d1, Temporal d2, ChronoUnit unit){
		return  unit.between(d1, d2);
	}

}

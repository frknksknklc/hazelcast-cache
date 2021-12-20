package com.example.demohazelcastcache;

import com.example.demohazelcastcache.services.PersonServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class DemoHazelcastCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoHazelcastCacheApplication.class, args);
	}

	@Bean
	PersonServices personServices(){
		return new PersonServices();
	}

}

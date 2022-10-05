package org.plywacz.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

import java.util.Collection;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@GetMapping()
	public String debugRequest() {
		return "Home";
	}

}

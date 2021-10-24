package br.com.amado.rhalpha;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RhalphaApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RhalphaApplication.class);
		app.setDefaultProperties(Collections
	          	.singletonMap("server.port", "8085"));
		app.run(args);
	}

}

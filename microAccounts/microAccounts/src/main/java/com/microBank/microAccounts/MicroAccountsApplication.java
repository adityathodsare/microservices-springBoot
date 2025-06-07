package com.microBank.microAccounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class MicroAccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroAccountsApplication.class, args);
		//git add .
 		//git commit -m "Updated feature or bug fix description"
 		//git push origin main
	}

}

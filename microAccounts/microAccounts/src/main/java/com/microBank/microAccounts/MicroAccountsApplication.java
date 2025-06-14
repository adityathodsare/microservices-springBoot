package com.microBank.microAccounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// if our controllers are out of maun poackege then we need to add this
/*@ComponentScans({ @ComponentScan("com.aditya.accounts.controller") })
@EnableJpaRepositories("com.aditya.accounts.repository")
@EntityScan("com.aditya.accounts.model")*/
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservices REST API",
				version = "1.0",
				description = "Accounts API Documentation",
				contact = @Contact(
						name = "aditya thodsare",
						email = "thodsareaditya@gmail.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "ourwebaddress.com"
				)
		),

		externalDocs = @ExternalDocumentation(
				description = "Accounts Documentation",
				url = "ourwebaddress.com"
		)
)
public class   MicroAccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroAccountsApplication.class, args);
		//git add .
 		//git commit -m "Updated feature or bug fix description"
 		//git push origin main
	}

}

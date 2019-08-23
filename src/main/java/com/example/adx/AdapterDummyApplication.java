package com.example.adx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/* @SpringBootApplication 
 * Indicates a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning. 
 * This is a convenienceannotation that is equivalent to declaring @Configuration, @EnableAutoConfiguration and @ComponentScan.
 */

/* @EnableJpaRepositories
 * Annotation to enable JPA repositories. Will scan the package of the annotated configuration class for Spring Datarepositories by default.
 */


@EnableJpaRepositories(basePackages = "com.example.adx.repository")
@SpringBootApplication
public class AdapterDummyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdapterDummyApplication.class, args);
	}

}

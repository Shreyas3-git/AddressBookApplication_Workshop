package com.bridgelabz.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Slf4j
@EnableSwagger2
public class AddressBookAppApplication 
{

	public static void main(String[] args) 
	{
		ApplicationContext context = SpringApplication.run(AddressBookAppApplication.class, args);
		log.info("AddressBook Application Database username is {}"
				,context.getEnvironment().getProperty("spring.datasource.username"));
	}

}

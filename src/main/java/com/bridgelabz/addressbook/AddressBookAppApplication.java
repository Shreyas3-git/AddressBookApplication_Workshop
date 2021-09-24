package com.bridgelabz.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class AddressBookAppApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(AddressBookAppApplication.class, args);
	}

}

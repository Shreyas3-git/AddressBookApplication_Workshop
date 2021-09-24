package com.bridgelabz.addressbook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "addressbook_contacts")
public class AddressBookEntity 
{
	@Id
	@GeneratedValue()
	private int id;
	
	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = " First name is not valid:")
	private String firstName;
	
	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = "Last name is not valid:")
	private String lastName;
	
	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = "address is not valid:")
	private String address;

	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = "city pattern is not valid:")
	private String city;
	
	@Pattern(regexp = "^[1-9]{1}[0-9]{5}$",message = "zip pattern is not valid")
	private int zip;
	
	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = "state pattern is not valid:")
	private String state;
	
	@Pattern(regexp = "^[7-9]{1}[0-9]{9}$",message = "phone pattern is not valid")
	private String phone;


	public AddressBookEntity(AddressBookDTO dto) 
	{
		super();
		this.firstName = dto.getFirstName();
		this.lastName = dto.getLastName();
		this.address = dto.getAddress();
		this.city = dto.getCity();
		this.zip = dto.getZip();
		this.state = dto.getState();
		this.phone = dto.getPhone();
	}
	
}

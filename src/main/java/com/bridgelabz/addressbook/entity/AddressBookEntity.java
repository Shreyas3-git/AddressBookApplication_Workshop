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
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookEntity 
{
	private int id;
	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = "name is not valid:")
	private String name;
	@Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = "address is not valid:")
	private String address;	
	
}

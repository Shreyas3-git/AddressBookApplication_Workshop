package com.bridgelabz.addressbook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.addressbook.dto.AddressBookDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressBookEntity 
{
	private int id;
	private String name;
	private String address;
	
	public AddressBookEntity(AddressBookDTO dto) 
	{
		this.name = dto.getName();
		this.address = dto.getAddress();
	}
	
	
}

package com.bridgelabz.addressbook.dto;

import com.bridgelabz.addressbook.entity.AddressBookEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO 
{
	public String name;
	public String address;
}

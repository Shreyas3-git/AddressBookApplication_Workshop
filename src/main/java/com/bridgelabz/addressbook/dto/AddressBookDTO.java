package com.bridgelabz.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO 
{
	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public int zip;
	public String state;
	public String phone;

}

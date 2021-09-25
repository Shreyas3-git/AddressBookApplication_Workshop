package com.bridgelabz.addressbook.dto;

import org.springframework.data.domain.Sort;

import lombok.Data;

@Data
public class AddressBookPage 
{
	private int pageNumber;
	private int pageSize;
	private Sort.Direction sortDirection = Sort.Direction.ASC;
	private	String SortBy = "firstName";
	
	
}

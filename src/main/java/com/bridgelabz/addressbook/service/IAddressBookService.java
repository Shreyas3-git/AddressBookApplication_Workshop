package com.bridgelabz.addressbook.service;

import java.util.List;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.AddressBookEntity;

public interface IAddressBookService 
{
	public List<AddressBookEntity> retriveAllData();
	public AddressBookEntity retriveById(int id);
	public AddressBookEntity insertRecord(AddressBookDTO dto);
	public AddressBookEntity updateRecord(AddressBookDTO dto,int id);
	public AddressBookEntity deleteById(int id);
}

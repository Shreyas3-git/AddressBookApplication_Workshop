package com.bridgelabz.addressbook.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.AddressBookPage;
import com.bridgelabz.addressbook.entity.AddressBookEntity;

public interface IAddressBookService 
{
	public Page<AddressBookEntity> retriveAllData(AddressBookPage Page);
	public AddressBookEntity retriveById(int id);
	public AddressBookEntity insertRecord(AddressBookDTO dto);
	public AddressBookEntity updateRecord(AddressBookDTO dto,int id);
	public AddressBookEntity deleteById(int id);
}

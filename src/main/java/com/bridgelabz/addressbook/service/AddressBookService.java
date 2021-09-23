package com.bridgelabz.addressbook.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.entity.AddressBookEntity;
import com.bridgelabz.addressbook.exception.InputNotAccepted;
import com.bridgelabz.addressbook.exception.NotFoundException;

@Service
public class AddressBookService implements IAddressBookService
{
	private List<AddressBookEntity> contactList = new ArrayList<>(Arrays.asList(
					new AddressBookEntity(1,"Rakesh","Mumbai"),
					new AddressBookEntity(2,"Suresh","Kolkata"),
					new AddressBookEntity(3,"Viraj","Pune")));
	@Override
	public List<AddressBookEntity> retriveAllData() 
	{
		long numberOfRecord = contactList.size();
		if (numberOfRecord == 0)
		{
			throw new NotFoundException("ContactList is Empty NoSuchElement");
		}
		return contactList;
	}

	@Override
	public AddressBookEntity retriveById(int id) 
	{
		AddressBookEntity entity = new AddressBookEntity();
		for(int i = 0; i < contactList.size(); i++)
		{
			if (id == entity.getId()) 
			{
				return contactList.stream().findFirst().get();
			}

		}
		throw new NotFoundException("ContactList is Empty NoSuchElement");

	}

	@Override
	public AddressBookEntity insertRecord(AddressBookEntity entity) 
	{
		if (contactList.contains(entity)) 
		{
			throw new InputNotAccepted("contact is already present in contactList");
		}
		else
		{
			contactList.add(entity);
			return null;
		}
	}

	@Override
	public AddressBookEntity updateRecord(AddressBookEntity entity,int id) 
	{
		for(int i = 0; i < contactList.size(); i++)
		{
			AddressBookEntity t = contactList.get(i);
			if (t.getId() == id)
			{
				contactList.set(i, entity);
				return null;
			}
			else
			{
				throw new InputNotAccepted("contact Id is not present in addressbook contactList");
			}
		}
		return null;
	}

	@Override
	public AddressBookEntity deleteById(int id) 
	{
		AddressBookEntity entity = null;
		if (entity.getId() == id) 
		{
			contactList.remove(id);
			return null;
		}
		else 
		{
			throw new NotFoundException("contact Id is not found for deletion in addressbook contactList ");
		}
	}

}

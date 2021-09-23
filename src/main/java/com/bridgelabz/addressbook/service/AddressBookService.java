package com.bridgelabz.addressbook.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.entity.AddressBookEntity;

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
		return contactList;
	}

	@Override
	public AddressBookEntity retriveById(int id) 
	{
		AddressBookEntity entity = new AddressBookEntity();
		if (id == entity.getId()) 
		{
			return contactList.stream().findFirst().get();
		}
		return null;
	}

	@Override
	public AddressBookEntity insertRecord(AddressBookEntity entity) 
	{
		contactList.add(entity);
		return null;
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
		}
		return null;
	}

	@Override
	public AddressBookEntity deleteById(int id) 
	{
		contactList.remove(id);
		return null;
	}

}

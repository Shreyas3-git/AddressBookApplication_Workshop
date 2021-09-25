package com.bridgelabz.addressbook.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.AddressBookPage;
import com.bridgelabz.addressbook.entity.AddressBookEntity;
import com.bridgelabz.addressbook.exception.EmptyAddressBookException;
import com.bridgelabz.addressbook.exception.InputNotAccepted;
import com.bridgelabz.addressbook.exception.NotFoundException;
import com.bridgelabz.addressbook.repository.IAdderssBookRepository;

@Service
public class AddressBookService implements IAddressBookService
{
	@Autowired
	private IAdderssBookRepository repository;
	
	public Page<AddressBookEntity> retriveAllData(AddressBookPage page) 
	{
		Sort sort = Sort.by(page.getSortDirection(),page.getSortBy());
		
		Pageable Pageable = PageRequest.of(page.getPageNumber(),page.getPageSize(),sort);
		return repository.findAll(Pageable);
	}

	@Override
	public AddressBookEntity retriveById(int id) 
	{
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Id Not found NoSuchElement"));
	}

	@Override
	public AddressBookEntity insertRecord(AddressBookDTO dto) 
	{
		AddressBookEntity entity = new AddressBookEntity(dto);
//		List<AddressBookEntity> contactList = repository.findAll();
//		if (contactList.contains(entity.getId())) 
//		{
//			throw new InputNotAccepted("Id will already present in the list");
//		}
		return repository.save(entity);
	}

	@Override
	public AddressBookEntity updateRecord(AddressBookDTO dto,int id) 
	{
		AddressBookEntity entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Id Not found NoSuchElement"));
		
//		if (dto.getAddress().equals(null) || dto.getFirstName().equals(null) || dto.getLastName().equals(null)
//				 || dto.getPhone().isBlank() || dto.getState().equals(null) ) 
//		{
//			throw new InputNotAccepted("Filed Should Not Empty Exception");
//		}
		BeanUtils.copyProperties(dto, entity);
		return repository.save(entity);
	}

	@Override
	public AddressBookEntity deleteById(int id) 
	{
		AddressBookEntity entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Id Not found NoSuchElement"));
		repository.deleteById(id);
		return null;
	}



}

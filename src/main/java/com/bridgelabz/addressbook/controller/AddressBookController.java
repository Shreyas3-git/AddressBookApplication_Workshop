package com.bridgelabz.addressbook.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.entity.AddressBookEntity;
import com.bridgelabz.addressbook.exception.EmptyAddressBookException;
import com.bridgelabz.addressbook.exception.InputNotAccepted;
import com.bridgelabz.addressbook.exception.NotFoundException;
import com.bridgelabz.addressbook.service.IAddressBookService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class AddressBookController 
{
	@Autowired
	private IAddressBookService addressbookService;
	
	@GetMapping(value = "/retrive")
	public ResponseEntity<ResponseDTO> getAllDetails()
	{	
//		try 
//		{
			List<AddressBookEntity> entity = addressbookService.retriveAllData();
			ResponseDTO dto = new ResponseDTO("All Data retrive successfully (:",entity);
			return new ResponseEntity(dto,HttpStatus.OK);
//		}
//		catch(EmptyAddressBookException exception)
//		{
//			ResponseDTO dto = new ResponseDTO("Error while processing empty AddressBook contactList",null);
//			return new ResponseEntity(dto,HttpStatus.NOT_FOUND); 
//		}
//		catch(Exception exception)
//		{
//			ResponseDTO dto = new ResponseDTO("Error while processing request",null);
//			return new ResponseEntity(dto,HttpStatus.BAD_REQUEST); 
//		}

		
	}
	

	@GetMapping(value = "/retrive/{id}")
	public ResponseEntity<ResponseDTO> getDataById(@PathVariable int id)
	{
//		try 
//		{
			AddressBookEntity entity = addressbookService.retriveById(id);
			ResponseDTO dto = new ResponseDTO(" Data retrive successfully for id (: "+id,entity);
			return new ResponseEntity(dto,HttpStatus.OK);
//		}
//		catch(NotFoundException exception)
//		{
//			ResponseDTO dto = new ResponseDTO("Contact not found NoSuchElement",null);
//			return new ResponseEntity(dto,HttpStatus.NOT_FOUND); 
//		}
//		catch(Exception exception)
//		{
//			ResponseDTO dto = new ResponseDTO("Error while processing request",null);
//			return new ResponseEntity(dto,HttpStatus.BAD_REQUEST); 
//		}
//
	}
		
	@PostMapping(value = "/insert")
	public ResponseEntity<ResponseDTO> addRecord(@Valid @RequestBody AddressBookEntity addressbookEntity)
	{
//		try
//		{
			AddressBookEntity entity = addressbookService.insertRecord(addressbookEntity);
			ResponseDTO dto = new ResponseDTO(" Data inserted successfully (: ",entity);
			return new ResponseEntity(dto,HttpStatus.OK);
//		}
//		catch(InputNotAccepted exception)
//		{
//			ResponseDTO dto = new ResponseDTO(" Error while processing userInput ",exception.getMessage());
//			return new ResponseEntity(dto,HttpStatus.NOT_ACCEPTABLE);
//		}
//		catch(Exception exception)
//		{
//			ResponseDTO dto = new ResponseDTO("Error while processing request",null);
//			return new ResponseEntity(dto,HttpStatus.BAD_REQUEST); 
//		}

	}
	

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ResponseDTO> ModifyRecord(@Valid @RequestBody AddressBookEntity addressbookEntity,@PathVariable int id)
	{
//		try 
//		{
			AddressBookEntity entity = addressbookService.updateRecord(addressbookEntity, id);
			ResponseDTO dto = new ResponseDTO(" Data updated successfully for id (: ",entity);
			return new ResponseEntity(dto,HttpStatus.OK);
//		}
//		catch(InputNotAccepted exception)
//		{
//			ResponseDTO dto = new ResponseDTO(" Error while processing userInput ",null);
//			return new ResponseEntity(dto,HttpStatus.NOT_ACCEPTABLE);
//		}
//		catch(Exception exception)
//		{
//			ResponseDTO dto = new ResponseDTO("Error while processing request",null);
//			return new ResponseEntity(dto,HttpStatus.BAD_REQUEST); 
//		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteById(@PathVariable int id)
	{
//		try
//		{
			AddressBookEntity entity = addressbookService.deleteById(id);
			ResponseDTO dto = new ResponseDTO(" Data inserted successfully for id (: ",entity);
			return new ResponseEntity(dto,HttpStatus.OK);
//		}
//		catch(NotFoundException exception)
//		{
//			ResponseDTO dto = new ResponseDTO("Contact not found NoSuchElement",null);
//			return new ResponseEntity(dto,HttpStatus.NOT_FOUND); 
//		}
//		catch(Exception exception)
//		{
//			ResponseDTO dto = new ResponseDTO("Error while processing request",null);
//			return new ResponseEntity(dto,HttpStatus.BAD_REQUEST); 
//		}

	}
	
}

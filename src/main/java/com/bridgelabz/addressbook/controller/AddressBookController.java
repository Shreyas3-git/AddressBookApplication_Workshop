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


@Slf4j
@RestController
public class AddressBookController 
{
	@Autowired
	private IAddressBookService addressbookService;
	
	@GetMapping(value = "/retrive")
	public ResponseEntity<ResponseDTO> getAllDetails()
	{	
		log.info("retrive all Data here");
		List<AddressBookEntity> entity = addressbookService.retriveAllData();
		ResponseDTO dto = new ResponseDTO("All Data retrive successfully (:",entity);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
	

	@GetMapping(value = "/retrive/{id}")
	public ResponseEntity<ResponseDTO> getDataById(@PathVariable int id)
	{
		AddressBookEntity entity = addressbookService.retriveById(id);
		ResponseDTO dto = new ResponseDTO(" Data retrive successfully for id (: "+id,entity);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
		
	@PostMapping(value = "/insert")
	public ResponseEntity<ResponseDTO> addRecord(@Valid @RequestBody AddressBookDTO addressbookDTO)
	{
		AddressBookEntity entity = addressbookService.insertRecord(addressbookDTO);
		ResponseDTO dto = new ResponseDTO(" Data inserted successfully (: ",entity);
		return new ResponseEntity(dto,HttpStatus.OK);

	}
	

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ResponseDTO> ModifyRecord(@Valid @RequestBody AddressBookDTO addressbookDTO,@PathVariable int id)
	{
		AddressBookEntity entity = addressbookService.updateRecord(addressbookDTO, id);
		ResponseDTO dto = new ResponseDTO(" Data updated successfully for id (: ",entity);
		return new ResponseEntity(dto,HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteById(@PathVariable int id)
	{
		AddressBookEntity entity = addressbookService.deleteById(id);
		ResponseDTO dto = new ResponseDTO(" Data inserted successfully for id (: ",entity);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
	
}

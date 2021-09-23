package com.bridgelabz.addressbook.controller;


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


@RestController
public class AddressBookController 
{

	@GetMapping(value = "/retrive")
	public ResponseEntity<String> getAllDetails()
	{
		return new ResponseEntity("All Data retrive successfully (:",HttpStatus.OK);
	}
	

	@GetMapping(value = "/retrive/{id}")
	public ResponseEntity getDataById(@PathVariable int id)
	{
		return new ResponseEntity("Data retrived successfully for Id:"+id,HttpStatus.OK);
	}


	@PostMapping(value = "/insert")
	public ResponseEntity addRecord(@RequestBody AddressBookDTO addressbookDTO)
	{
		return new ResponseEntity("Data inserted successfully (:"+addressbookDTO,HttpStatus.ACCEPTED);
	}
	

	@PutMapping(value = "/update/{id}")
	public ResponseEntity ModifyRecord(@RequestBody AddressBookDTO addressbookDTO,@PathVariable int id)
	{
		return new ResponseEntity("Data updated successfully for id"+id,HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity deleteById(@PathVariable int id)
	{
		return new ResponseEntity("Data updated deleted successfully for id (:"+id,HttpStatus.ACCEPTED);
	}
	
}

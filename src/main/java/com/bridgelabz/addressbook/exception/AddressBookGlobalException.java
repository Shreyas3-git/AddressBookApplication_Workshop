package com.bridgelabz.addressbook.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.bridgelabz.addressbook.dto.ResponseDTO;


@ControllerAdvice
public class AddressBookGlobalException 
{
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception)
	{
		List<ObjectError> errors = exception.getBindingResult().getAllErrors();
		List<String> errorMessages = errors.stream().map(i -> i.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO dto = new ResponseDTO("Exception while processing request: MethodArgumentNotValid",errorMessages);
		return new ResponseEntity(dto,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ResponseDTO> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception)
	{
		ResponseDTO dto = new ResponseDTO("Request Type Not Supported Exception:",exception.getRootCause());
		return new ResponseEntity(dto,HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ResponseDTO> handleCustomException(CustomException exception)
	{
		if (exception instanceof NotFoundException) 
		{
			ResponseDTO dto = new ResponseDTO("Error while processing the user input",exception.getMessage());
			return new ResponseEntity<ResponseDTO>(dto,HttpStatus.NOT_FOUND);
		}
		else if(exception instanceof InputNotAccepted)
		{
			ResponseDTO dto = new ResponseDTO("Error while updating user data",exception.getMessage());
			return new ResponseEntity<ResponseDTO>(dto,HttpStatus.NOT_ACCEPTABLE);

		}
		return null;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> handleException(Exception exception)
	{
		ResponseDTO dto = new ResponseDTO("Error while processing the user input",exception.getMessage());
		return new ResponseEntity<ResponseDTO>(dto,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

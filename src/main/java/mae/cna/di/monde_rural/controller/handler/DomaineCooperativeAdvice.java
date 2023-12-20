package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.DomaineCooperativeAlreadyExistException;
import mae.cna.di.monde_rural.exception.DomaineCooperativeIsFatherException;
import mae.cna.di.monde_rural.exception.DomaineCooperativeNotFoundException;

@ControllerAdvice
public class DomaineCooperativeAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(DomaineCooperativeAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String DomaineCooperativeAlreadyExistAdvice(DomaineCooperativeAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(DomaineCooperativeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String DomaineCooperativeNotFoundAdvice(DomaineCooperativeNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(DomaineCooperativeIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String DomaineCooperativeIsFatherAdvice(DomaineCooperativeIsFatherException ex)
	{
		return ex.getMessage();
	}

}

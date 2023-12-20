package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.DomaineAlreadyExistException;
import mae.cna.di.monde_rural.exception.DomaineIsFatherException;
import mae.cna.di.monde_rural.exception.DomaineNotFoundException;

@ControllerAdvice
public class DomaineAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(DomaineAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String DomaineAlreadyExistAdvice(DomaineAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(DomaineNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String DomaineNotFoundAdvice(DomaineNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(DomaineIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String DomaineIsFatherAdvice(DomaineIsFatherException ex)
	{
		return ex.getMessage();
	}

}

package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.MembreEtProducteurAlreadyExistException;
import mae.cna.di.monde_rural.exception.MembreEtProducteurIsFatherException;
import mae.cna.di.monde_rural.exception.MembreEtProducteurNotFoundException;

@ControllerAdvice
public class MembreEtProducteurAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(MembreEtProducteurAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String MembreEtProducteurAlreadyExistAdvice(MembreEtProducteurAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(MembreEtProducteurNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String MembreEtProducteurNotFoundAdvice(MembreEtProducteurNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(MembreEtProducteurIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String MembreEtProducteurIsFatherAdvice(MembreEtProducteurIsFatherException ex)
	{
		return ex.getMessage();
	}

}

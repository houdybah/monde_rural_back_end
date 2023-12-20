package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.PersonnelAlreadyExistException;
import mae.cna.di.monde_rural.exception.PersonnelIsFatherException;
import mae.cna.di.monde_rural.exception.PersonnelNotFoundException;

@ControllerAdvice
public class personnelAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(PersonnelAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String PersonnelAlreadyExistAdvice(PersonnelAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(PersonnelNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String PersonnelNotFoundAdvice(PersonnelNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(PersonnelIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String PersonnelIsFatherAdvice(PersonnelIsFatherException ex)
	{
		return ex.getMessage();
	}

}

package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.RaceFamilleAlreadyExistException;
import mae.cna.di.monde_rural.exception.RaceFamilleIsFatherException;
import mae.cna.di.monde_rural.exception.RaceFamilleNotFoundException;

@ControllerAdvice
public class RaceFamilleAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(RaceFamilleAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String RaceFamilleAlreadyExistAdvice(RaceFamilleAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(RaceFamilleNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String RaceFamilleNotFoundAdvice(RaceFamilleNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(RaceFamilleIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String RaceFamilleIsFatherAdvice(RaceFamilleIsFatherException ex)
	{
		return ex.getMessage();
	}

}

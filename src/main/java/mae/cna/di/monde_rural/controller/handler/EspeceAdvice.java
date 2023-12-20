package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.EspeceAlreadyExistException;
import mae.cna.di.monde_rural.exception.EspeceIsFatherException;
import mae.cna.di.monde_rural.exception.EspeceNotFoundException;

@ControllerAdvice
public class EspeceAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(EspeceAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String EspeceAlreadyExistAdvice(EspeceAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(EspeceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String EspeceNotFoundAdvice(EspeceNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(EspeceIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String EspeceIsFatherAdvice(EspeceIsFatherException ex)
	{
		return ex.getMessage();
	}

}

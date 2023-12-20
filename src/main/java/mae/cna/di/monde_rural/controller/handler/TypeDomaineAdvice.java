package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.TypeDomaineAlreadyExistException;
import mae.cna.di.monde_rural.exception.TypeDomaineIsFatherException;
import mae.cna.di.monde_rural.exception.TypeDomaineNotFoundException;

@ControllerAdvice
public class TypeDomaineAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(TypeDomaineAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String TypeDomaineAlreadyExistAdvice(TypeDomaineAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(TypeDomaineNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String TypeDomaineNotFoundAdvice(TypeDomaineNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(TypeDomaineIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String TypeDomaineIsFatherAdvice(TypeDomaineIsFatherException ex)
	{
		return ex.getMessage();
	}

}

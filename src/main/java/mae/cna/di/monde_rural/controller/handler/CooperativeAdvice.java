package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.CooperativeAlreadyExistException;
import mae.cna.di.monde_rural.exception.CooperativeIsFatherException;
import mae.cna.di.monde_rural.exception.CooperativeNotFoundException;

@ControllerAdvice
public class CooperativeAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(CooperativeAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String CooperativeAlreadyExistAdvice(CooperativeAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(CooperativeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String CooperativeNotFoundAdvice(CooperativeNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(CooperativeIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String CooperativeIsFatherAdvice(CooperativeIsFatherException ex)
	{
		return ex.getMessage();
	}

}

package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.ChambreAlreadyExistException;
import mae.cna.di.monde_rural.exception.ChambreIsFatherException;
import mae.cna.di.monde_rural.exception.ChambreNotFoundException;

@ControllerAdvice
public class ChambreAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(ChambreAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String ChambreAlreadyExistAdvice(ChambreAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(ChambreNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String ChambreNotFoundAdvice(ChambreNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(ChambreIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String ChambreIsFatherAdvice(ChambreIsFatherException ex)
	{
		return ex.getMessage();
	}

}

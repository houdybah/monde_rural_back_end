package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.LieuAlreadyExistException;
import mae.cna.di.monde_rural.exception.LieuIsFatherException;
import mae.cna.di.monde_rural.exception.LieuNotFoundException;

@ControllerAdvice
public class LieuAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(LieuAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String LieuAlreadyExistAdvice(LieuAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(LieuNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String LieuNotFoundAdvice(LieuNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(LieuIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String LieuIsFatherAdvice(LieuIsFatherException ex)
	{
		return ex.getMessage();
	}

}

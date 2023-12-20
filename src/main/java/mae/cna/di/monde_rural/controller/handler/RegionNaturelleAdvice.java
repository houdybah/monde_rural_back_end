package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.RegionNaturelleAlreadyExistException;
import mae.cna.di.monde_rural.exception.RegionNaturelleIsFatherException;
import mae.cna.di.monde_rural.exception.RegionNaturelleNotFoundException;

@ControllerAdvice
public class RegionNaturelleAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(RegionNaturelleAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String RegionNaturelleAlreadyExistAdvice(RegionNaturelleAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(RegionNaturelleNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String RegionNaturelleNotFoundAdvice(RegionNaturelleNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(RegionNaturelleIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String RegionNaturelleIsFatherAdvice(RegionNaturelleIsFatherException ex)
	{
		return ex.getMessage();
	}

}

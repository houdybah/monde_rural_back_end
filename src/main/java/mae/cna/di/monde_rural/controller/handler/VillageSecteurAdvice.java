package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.VillageSecteurAlreadyExistException;
import mae.cna.di.monde_rural.exception.VillageSecteurIsFatherException;
import mae.cna.di.monde_rural.exception.VillageSecteurNotFoundException;

@ControllerAdvice
public class VillageSecteurAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(VillageSecteurAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String VillageSecteurAlreadyExistAdvice(VillageSecteurAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(VillageSecteurNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String VillageSecteurNotFoundAdvice(VillageSecteurNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(VillageSecteurIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String VillageSecteurIsFatherAdvice(VillageSecteurIsFatherException ex)
	{
		return ex.getMessage();
	}

}

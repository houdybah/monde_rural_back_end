package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.RegionAdministrativeAlreadyExistException;
import mae.cna.di.monde_rural.exception.RegionAdministrativeIsFatherException;
import mae.cna.di.monde_rural.exception.RegionAdministrativeNotFoundException;

@ControllerAdvice
public class RegionAdministrativeAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(RegionAdministrativeAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String RegionAdministrativeAlreadyExistAdvice(RegionAdministrativeAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(RegionAdministrativeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String RegionAdministrativeNotFoundAdvice(RegionAdministrativeNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(RegionAdministrativeIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String RegionAdministrativeIsFatherAdvice(RegionAdministrativeIsFatherException ex)
	{
		return ex.getMessage();
	}

}

package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.DistrictQuartierAlreadyExistException;
import mae.cna.di.monde_rural.exception.DistrictQuartierIsFatherException;
import mae.cna.di.monde_rural.exception.DistrictQuartierNotFoundException;

@ControllerAdvice
public class DistrictQuartierAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(DistrictQuartierAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String DistrictQuartierAlreadyExistAdvice(DistrictQuartierAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(DistrictQuartierNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String DistrictQuartierNotFoundAdvice(DistrictQuartierNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(DistrictQuartierIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String DistrictQuartierIsFatherAdvice(DistrictQuartierIsFatherException ex)
	{
		return ex.getMessage();
	}

}

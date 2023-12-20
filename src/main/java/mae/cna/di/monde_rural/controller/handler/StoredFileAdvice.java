package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.StoredFileAlreadyExistException;
import mae.cna.di.monde_rural.exception.StoredFileIsFatherException;
import mae.cna.di.monde_rural.exception.StoredFileNotFoundException;

@ControllerAdvice
public class StoredFileAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(StoredFileAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String StoredFileAlreadyExistAdvice(StoredFileAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(StoredFileNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String StoredFileNotFoundAdvice(StoredFileNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(StoredFileIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String StoredFileIsFatherAdvice(StoredFileIsFatherException ex)
	{
		return ex.getMessage();
	}

}

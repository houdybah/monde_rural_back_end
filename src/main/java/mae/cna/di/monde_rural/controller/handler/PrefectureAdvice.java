package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.PrefectureAlreadyExistException;
import mae.cna.di.monde_rural.exception.PrefectureIsFatherException;
import mae.cna.di.monde_rural.exception.PrefectureNotFoundException;

@ControllerAdvice
public class PrefectureAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(PrefectureAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String PrefectureAlreadyExistAdvice(PrefectureAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(PrefectureNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String PrefectureNotFoundAdvice(PrefectureNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(PrefectureIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String PrefectureIsFatherAdvice(PrefectureIsFatherException ex)
	{
		return ex.getMessage();
	}

}

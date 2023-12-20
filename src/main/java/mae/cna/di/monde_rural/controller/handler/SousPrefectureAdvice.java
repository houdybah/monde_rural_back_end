package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.SousPrefectureAlreadyExistException;
import mae.cna.di.monde_rural.exception.SousPrefectureIsFatherException;
import mae.cna.di.monde_rural.exception.SousPrefectureNotFoundException;

@ControllerAdvice
public class SousPrefectureAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(SousPrefectureAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String SousPrefectureAlreadyExistAdvice(SousPrefectureAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(SousPrefectureNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String SousPrefectureNotFoundAdvice(SousPrefectureNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(SousPrefectureIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String SousPrefectureIsFatherAdvice(SousPrefectureIsFatherException ex)
	{
		return ex.getMessage();
	}

}

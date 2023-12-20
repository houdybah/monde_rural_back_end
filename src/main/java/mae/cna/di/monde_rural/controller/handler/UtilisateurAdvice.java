package mae.cna.di.monde_rural.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import mae.cna.di.monde_rural.exception.EmailInvalidException;
import mae.cna.di.monde_rural.exception.UtilisateurAlreadyExistException;
import mae.cna.di.monde_rural.exception.UtilisateurIsFatherException;
import mae.cna.di.monde_rural.exception.UtilisateurNotFoundException;

@ControllerAdvice
public class UtilisateurAdvice {
	
	
	@ResponseBody
	@ExceptionHandler(UtilisateurAlreadyExistException.class)
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public String UtilisateurAlreadyExistAdvice(UtilisateurAlreadyExistException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(UtilisateurNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String UtilisateurNotFoundAdvice(UtilisateurNotFoundException ex)
	{
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(UtilisateurIsFatherException.class)
	@ResponseStatus(HttpStatus.NOT_MODIFIED)
	public String UtilisateurIsFatherAdvice(UtilisateurIsFatherException ex)
	{
		return ex.getMessage();
	}
	
	
	@ResponseBody
	@ExceptionHandler(EmailInvalidException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String EmailInvalidAdvice(EmailInvalidException ex)
	{
		return ex.getMessage();
	}

}

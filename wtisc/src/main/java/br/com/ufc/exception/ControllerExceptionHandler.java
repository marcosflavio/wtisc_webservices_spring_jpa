package br.com.ufc.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.ufc.dto.ExceptionDTO;

@ControllerAdvice				//anotacao para sobrescreveer o que o json envia de excecao para o usuario
@Configuration				// spring cria configuraçoes de forma automática por tras
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{ //manipulador de excecoes do response entity
	
	@ExceptionHandler(value = {ConstraintViolationException.class})								//restringir que eh pra excecao constraintValidation
	protected ResponseEntity<Object> constraintValidationException(ConstraintViolationException ex
			, WebRequest request){
		
		List<ExceptionDTO> response = new ArrayList<ExceptionDTO>();
		HttpHeaders headers = new HttpHeaders(); //nao serve pra mt coisa, pesqusiar!
		HttpStatus status = HttpStatus.BAD_REQUEST; // armazena qual foi o tipo de requisiçao errada que o usuario mandou
		
		//preencher a lista de excecoes
		for(ConstraintViolation<?> constraintValidation: ex.getConstraintViolations()){
			
			response.add(new ExceptionDTO(constraintValidation.getMessageTemplate().replaceAll("[{}]", ""), //tirando chaves da str 
					constraintValidation.getMessage()));
			
		}
		
		return handleExceptionInternal(ex, response, headers, status, request);
	}
	
	

}

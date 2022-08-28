package com.personal.application.swaggermicroservice.exception;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.personal.application.swaggermicroservice.PrimaryService;
import com.personal.application.swaggermicroservice.ServiceError;


@ControllerAdvice("com.personal.application.swaggermicroservice")
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler{

	private static Logger LOGGER = LoggerFactory.getLogger(PrimaryService.class);

	
	@ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleGenericException(final Exception ex ,final WebRequest request) {
		  ServiceError serviceError = new ServiceError(HttpStatus.BAD_REQUEST,Arrays.asList(ex.getMessage()),
					LocalDateTime.now(),request.getDescription(true));
		  
		  return new ResponseEntity(serviceError,new HttpHeaders(),serviceError.getHttpStatus());
    }
	
	  @ExceptionHandler(InvalidJsonException.class) 
	  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	  public ResponseEntity<?> invalidJsonErrorHandler(Exception ex, WebRequest request){
	  
		  LOGGER.info("invalidJson exception: " + ex.getMessage());
		  ServiceError serviceError = new ServiceError(HttpStatus.BAD_REQUEST,Arrays.asList(ex.getMessage()),
				  					LocalDateTime.now(),request.getDescription(true));
		  
		  return new ResponseEntity(serviceError,new HttpHeaders(),serviceError.getHttpStatus());
	  
	  }
	 
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request){
	
		List<FieldError> errorFields = ex.getBindingResult().getFieldErrors();
		List<String> errors = errorFields.stream()
								.map(err -> err.getDefaultMessage())
								.collect(Collectors.toList());
		
		ServiceError serviceError = new ServiceError(status,errors,
													LocalDateTime.now(),request.getDescription(true));
		
		return new ResponseEntity<Object>(serviceError,headers,serviceError.getHttpStatus());
		
	}

}

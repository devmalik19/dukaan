package devmalik90.dukaan.helper;

import devmalik90.dukaan.config.Config;
import devmalik90.dukaan.config.Exception;
import devmalik90.dukaan.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController
{
    @Autowired
    private Config config;

    @Autowired
    private Exception exception;

    @ExceptionHandler(java.lang.Exception.class)
    public ResponseEntity<RestExceptionResponse> catchAllExceptions(java.lang.Exception e)
    {
        String msg  =   config.isDebug()?e.getMessage():exception.getDefaultMessage();
        RestExceptionResponse    response =   new RestExceptionResponse(msg,HttpStatus.INTERNAL_SERVER_ERROR);
        return new  ResponseEntity<>(response,response.getHttpStatus());    
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        RestExceptionResponse    response    = new RestExceptionResponse(message,HttpStatus.UNPROCESSABLE_ENTITY);
        return  new  ResponseEntity<>(response,HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<RestExceptionResponse> resourceNotFoundException(ResourceNotFoundException e)
    {
        ResponseEntity<RestExceptionResponse>    response;
        response    =    new  ResponseEntity<>(e.getResponse(),e.getHttpStatus());
        return response;
    }
}

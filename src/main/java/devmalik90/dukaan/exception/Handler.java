package devmalik90.dukaan.exception;

import devmalik90.dukaan.config.Config;
import devmalik90.dukaan.config.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Handler
{
    @Autowired
    private Config config;

    @Autowired
    private Exception exception;

    @ExceptionHandler(java.lang.Exception.class)
    public ResponseEntity<Response> catchAllExceptions(java.lang.Exception e)
    {
        String msg  =   config.isDebug()?e.getMessage():exception.getDefaultMessage();
        Response    response =   new Response(msg,HttpStatus.INTERNAL_SERVER_ERROR);
        return new  ResponseEntity<>(response,response.getHttpStatus());    
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        Response    response    = new Response(message,HttpStatus.UNPROCESSABLE_ENTITY);
        return  new  ResponseEntity<>(response,HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response> resourceNotFoundException(ResourceNotFoundException e) 
    {
        ResponseEntity<Response>    response;
        response    =    new  ResponseEntity<>(e.getResponse(),e.getHttpStatus());
        return response;
    }
}

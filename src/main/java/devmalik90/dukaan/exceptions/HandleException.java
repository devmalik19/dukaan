package devmalik90.dukaan.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException
{
 
    @ExceptionHandler(ResourceNotFoundException.class)
    public void resourceNotFoundException() 
    {
        
    }
}

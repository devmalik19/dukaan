package devmalik90.dukaan.exception;

import devmalik90.dukaan.helper.RestExceptionResponse;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends Exception 
{
    private String errorMessage;
    private HttpStatus httpStatus;
    private RestExceptionResponse response;

    public ResourceNotFoundException() 
    {
        super();
        errorMessage    =   "Resource Not Found";
        httpStatus      =   HttpStatus.NOT_FOUND;
        response        =   new RestExceptionResponse(errorMessage, httpStatus);
    }

    public ResourceNotFoundException(String message)
    {
        super(message);
        errorMessage    =   message;
        httpStatus      =   HttpStatus.NOT_FOUND;
        response        =   new RestExceptionResponse(errorMessage, httpStatus);
    }

    public ResourceNotFoundException(String message,HttpStatus hStatus)
    {
        super(message);
        errorMessage    =   message;
        httpStatus      =   hStatus;
        response        =   new RestExceptionResponse(errorMessage, httpStatus);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public RestExceptionResponse getResponse() {
        return response;
    }

    public void setResponse(RestExceptionResponse response) {
        this.response = response;
    }
}

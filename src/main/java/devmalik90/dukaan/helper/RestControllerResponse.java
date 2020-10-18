package devmalik90.dukaan.helper;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

@Component
public class RestControllerResponse
{
    private Object responseObject;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

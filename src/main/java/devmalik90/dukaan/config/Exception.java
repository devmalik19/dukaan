package devmalik90.dukaan.config;

import org.springframework.stereotype.Component;

@Component
public class Exception
{
    private String defaultMessage = "Server Error";

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}

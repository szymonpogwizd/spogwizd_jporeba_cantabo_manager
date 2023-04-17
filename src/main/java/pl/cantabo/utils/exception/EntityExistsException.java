package pl.cantabo.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Resource already exists")
public class EntityExistsException extends RuntimeException {

    public EntityExistsException(String message) {
        super(message);
    }
}

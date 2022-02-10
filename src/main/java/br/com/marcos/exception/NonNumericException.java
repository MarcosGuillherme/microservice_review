package br.com.marcos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NonNumericException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public NonNumericException(String exceptionMsg) {
        super(exceptionMsg);
    }

}

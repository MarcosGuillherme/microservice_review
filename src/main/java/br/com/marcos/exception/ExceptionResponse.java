package br.com.marcos.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
public class ExceptionResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Getter
    private Date timeStamp;
    @Getter
    private String message;
    @Getter
    private String details;

}

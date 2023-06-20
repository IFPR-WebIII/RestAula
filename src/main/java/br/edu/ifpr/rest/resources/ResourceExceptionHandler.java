package br.edu.ifpr.rest.resources;

import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StandardError> idNaoEncontrado(NoSuchElementException exception){

        StandardError error = new StandardError("NoSuchElementException",
                HttpStatus.NOT_FOUND,
                System.currentTimeMillis(),
                "Id buscado não foi encontrado");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }
}

class StandardError{

    private String exception;
    private HttpStatus status;
    private Long timestamp;
    private String message;

    public StandardError(String exception, HttpStatus status, Long timestamp, String message) {
        this.exception = exception;
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

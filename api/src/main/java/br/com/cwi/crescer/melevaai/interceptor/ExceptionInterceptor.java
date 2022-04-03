package br.com.cwi.crescer.melevaai.interceptor;

import br.com.cwi.crescer.melevaai.controller.response.ErrorResponse;
import br.com.cwi.crescer.melevaai.exception.AbstractException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionInterceptor {


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse response = new ErrorResponse(exception.getMessage());

        log.error("Unexpected error", exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exception) {

        ErrorResponse response = new ErrorResponse(exception.getMessage());

        log.error("Method Argument Not Valid Error", exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(AbstractException exception) {

        ErrorResponse response = new ErrorResponse(exception.getError());

        log.error("Abstract error", exception);

        return new ResponseEntity<>(response, exception.getStatus());
    }
}

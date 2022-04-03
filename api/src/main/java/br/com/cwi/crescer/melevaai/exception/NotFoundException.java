package br.com.cwi.crescer.melevaai.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AbstractException {
    public NotFoundException(String error) {
        super(HttpStatus.NOT_FOUND, error);
    }
}

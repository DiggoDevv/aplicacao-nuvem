package me.estudo.aplicacao_nuvem.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionError {

    private final Logger logger  = LoggerFactory.getLogger(GlobalExceptionError.class);

                //mensagem da camada de negocio
                @ExceptionHandler(IllegalArgumentException.class)
                public ResponseEntity<String> handleBusinessException(IllegalArgumentException businessException) {
                    return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
                }
                //tratando a outra exceção da camada de negócio
                @ExceptionHandler(NoSuchElementException.class)
                public ResponseEntity<String> handleNotFoundException(NoSuchElementException notFoundException) {
                    return new ResponseEntity<>("Resource ID not found.", HttpStatus.NOT_FOUND);
                }
                //tratando qualquer outra exceção
                @ExceptionHandler(Throwable.class)
                public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
                    var message = "Unexpected server error, see the logs.";
                    logger.error(message, unexpectedException);
                    return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
                }
}

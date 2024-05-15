package frist.app.newapp.excption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import frist.app.newapp.entities.task.dto.ErrorDetailsDto;

@ControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<String> handleException(Exception ex) {

    // String errorMessage = ex.getMessage();

    // return
    // ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
    // }

    @ExceptionHandler(MyCustomException.class)
    public ResponseEntity<?> handleMyCustomException(MyCustomException ex, WebRequest request) {
        ErrorDetailsDto errorDetails = new ErrorDetailsDto(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
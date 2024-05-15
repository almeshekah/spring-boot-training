package frist.app.newapp.entities.task.dto;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ErrorDetailsDto {
    private Date timestamp;
    private int status;
    private String error;
    private String message;


    public ErrorDetailsDto(HttpStatus status, String message) {
        this.timestamp = new Date();
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = message;
    }

}
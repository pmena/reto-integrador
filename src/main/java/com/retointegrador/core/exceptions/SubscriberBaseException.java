package com.retointegrador.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriberBaseException extends RuntimeException{

    private HttpStatus status = HttpStatus.BAD_REQUEST;
    private String message;

    public SubscriberBaseException(String message){
        this.message = message;
    }
}

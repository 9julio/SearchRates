package com.jafernandez.searchrates.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.text.ParseException;

@Slf4j
@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity handleNumberFormatException(NumberFormatException e) {
        log.error(e.getMessage());
        return new ResponseEntity("Some field is mandatory or have a bad format.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ParseException.class)
    public ResponseEntity handleParseRequestException(ParseException e) {
        log.error(e.getMessage());
        return new ResponseEntity("Some field is mandatory or have a bad format.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity handleSQLException(SQLException e) {
        log.error(e.getMessage());
        return new ResponseEntity("An internal error has occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        log.error(e.getMessage());
        return new ResponseEntity("An internal error has occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

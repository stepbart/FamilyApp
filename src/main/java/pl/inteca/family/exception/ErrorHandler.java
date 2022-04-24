package pl.inteca.family.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotCorrectFamilyData.class)
    public ResponseEntity<Object> handleBadFamilyData(NotCorrectFamilyData exception) {
        return new ResponseEntity<>("Podano niepoprawne dane rodziny", HttpStatus.BAD_REQUEST);
    }
}

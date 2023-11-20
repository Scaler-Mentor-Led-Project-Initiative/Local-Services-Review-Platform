package RatingManagementService.ratingmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RatingRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<RatingErrorResponse> handleException(RatingNotFoundException exc){

        RatingErrorResponse error= new RatingErrorResponse(HttpStatus.NOT_FOUND.value(),exc.getMessage(),System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}

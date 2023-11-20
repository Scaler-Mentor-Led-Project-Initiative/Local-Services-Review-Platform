package RatingManagementService.ratingmanagement.exceptions;

public class RatingNotFoundException extends RuntimeException{
    public RatingNotFoundException(String message) {
        super(message);
    }
}

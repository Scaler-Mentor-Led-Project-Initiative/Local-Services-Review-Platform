package RatingManagementService.ratingmanagement.exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingErrorResponse{
    private int status;
    private String message;
    private long timeStamp;

    public RatingErrorResponse(){

    }

    public RatingErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}

package fit.nlu.appchat.enums;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.Getter;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Invalid key", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002, "User already exists", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "Username must be at least {min} characters", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(1004, "Password must be at least {min} characters", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User does not exist", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN),
    INVALID_DOB(1008, "Your age must be at least {min}", HttpStatus.BAD_REQUEST),
    USER_LOCKED(1009, "User is locked", HttpStatus.FORBIDDEN),
    EMAIL_ALREADY_REGISTERED(1010, "Email already registered", HttpStatus.CONFLICT),
    SESSION_EXPIRED(1011, "Session expired", HttpStatus.UNAUTHORIZED),
    DATABASE_ERROR(1012, "Database error", HttpStatus.INTERNAL_SERVER_ERROR),
    SERVICE_UNAVAILABLE(1013, "Service temporarily unavailable", HttpStatus.SERVICE_UNAVAILABLE),
    MESSAGE_NOT_EXISTED(1014, "Message does not exist", HttpStatus.NOT_FOUND),
    FRIEND_NOT_EXISTED(1015, "Friend does not exist", HttpStatus.NOT_FOUND),
    NOT_FRIENDS(1016, "Both users are not friends", HttpStatus.BAD_REQUEST),
    FRIEND_REQUEST_ALREADY_EXISTS(1017, "Friend request already exists", HttpStatus.CONFLICT),
    FRIEND_REQUEST_NOT_FOUND(1018, "Request does not exist", HttpStatus.NOT_FOUND),
    INVALID_DATE_FORMAT(1019, "Invalid date format", HttpStatus.BAD_REQUEST),
    GROUP_NOT_FOUND(1020, "Group not found", HttpStatus.NOT_FOUND),
    GROUP_OR_MEMBER_NOT_FOUND(1021, "Group or member not found", HttpStatus.NOT_FOUND);

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode statusCode;
}
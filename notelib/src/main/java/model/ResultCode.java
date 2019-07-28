package model;

public enum ResultCode {
    SUCCESS(200, "Success"),
    FAIL_INVALID_SUBJECT(101, "You've entered an invalid subject for your note."),
    FAIL_INVALID_CONTENT(102, "You've entered an invalid content for your note."),
    FAIL_SUBJECT_TOO_LONG(103, "Subject is too long."),
    FAIL_CONTENT_TOO_LONG(104, "Content is too long."),
    FAIL_WRONG_CREDENTIALS(105, "Wrong login information."),
    FAIL_INVALID_SESSION_ID(106, "Invalid session key. Try to login again."),
    FAIL_SESSION_EXPIRED(107, "Your session is expired. Try to login again.");

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

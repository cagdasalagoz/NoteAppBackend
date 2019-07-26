package model;

public class ResponseModel<T> {
    private int code;
    private String message;
    private T relatedObject;

    public ResponseModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseModel(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message =  resultCode.getMessage();
    }

    public ResponseModel(ResultCode resultCode, T relatedObject) {
        this.relatedObject = relatedObject;
        this.code = resultCode.getCode();
        this.message =  resultCode.getMessage();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getRelatedObject() {
        return relatedObject;
    }

    public void setRelatedObject(T relatedObject) {
        this.relatedObject = relatedObject;
    }
}

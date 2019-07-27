package model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel<T> {
    private int code;
    private String message;
    private T content;

    public ResponseModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseModel(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message =  resultCode.getMessage();
    }

    public ResponseModel(ResultCode resultCode, T relatedObject) {
        this.content = relatedObject;
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

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}

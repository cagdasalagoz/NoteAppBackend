package com.cagdasalagoz.noteservice.model;

import com.cagdasalagoz.noteservice.ResultCode;

public class ResponseModel {
    private int code;
    private String message;

    public ResponseModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseModel(ResultCode resultCode){
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
}

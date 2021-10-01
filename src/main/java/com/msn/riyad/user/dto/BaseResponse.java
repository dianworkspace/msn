package com.msn.riyad.user.dto;

public class BaseResponse {

    private String resultMsg;

    public BaseResponse() {
    }

    @Override
    public String toString() {
        return "BaseResponse{" + "resultMsg=" + resultMsg + '}';
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}

package com.msn.riyad.user.dto;

public class UserDetailResponse extends BaseResponse {

    private String email;

    private Integer age;

    private Boolean isActive;

    public UserDetailResponse() {
    }

    @Override
    public String toString() {
        return "UserDetailResponse{" + "email=" + email + ", age=" + age + ", isActive=" + isActive + '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}

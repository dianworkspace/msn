package com.msn.riyad.user.dto;

public class UserLoginResponse extends BaseResponse {

    private Boolean isActive;

    private Long customerId;

    private String email;

    public UserLoginResponse() {
    }

    @Override
    public String toString() {
        return "UserLoginResponse{" + "isActive=" + isActive + ", customerId=" + customerId + ", email=" + email + '}';
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

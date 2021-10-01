package com.msn.riyad.user.dto;

/**
 * @author Riyad
 *
 */
public class UserLoginRequest {

    private String email;

    private String password;

    public UserLoginRequest() {
    }

    @Override
    public String toString() {
        return "UserLoginRequest{" + "email=" + email + ", password=" + password + '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

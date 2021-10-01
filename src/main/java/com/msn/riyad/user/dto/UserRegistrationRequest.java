package com.msn.riyad.user.dto;

/**
 * @author Riyad
 *
 */
public class UserRegistrationRequest {

    private String email;

    private String password;

    private Integer age;

    @Override
    public String toString() {
        return "UserRegistrationRequest{" + "email=" + email + ", password=" + password + ", age=" + age + '}';
    }

    public UserRegistrationRequest() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}

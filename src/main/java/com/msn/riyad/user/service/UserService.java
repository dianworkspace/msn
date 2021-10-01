package com.msn.riyad.user.service;

import com.msn.riyad.user.dto.BaseResponse;
import com.msn.riyad.user.dto.UserDetailResponse;
import com.msn.riyad.user.dto.UserLoginRequest;
import com.msn.riyad.user.dto.UserLoginResponse;
import com.msn.riyad.user.dto.UserRegistrationRequest;

/**
 * @author Riyad
 *
 */
public interface UserService {

    public UserLoginResponse performCustomerLogin(UserLoginRequest request) throws Exception;

    public UserLoginResponse performCustomerLogout(String email) throws Exception;

    public BaseResponse performCustomerRegistration(UserRegistrationRequest request) throws Exception;

    public UserDetailResponse performCustomerInquiry() throws Exception;

    public void job();

}

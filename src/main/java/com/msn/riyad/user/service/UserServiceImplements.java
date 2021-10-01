package com.msn.riyad.user.service;

import com.msn.riyad.user.dto.BaseResponse;
import com.msn.riyad.user.dto.UserDetailResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msn.riyad.user.dto.UserLoginRequest;
import com.msn.riyad.user.dto.UserLoginResponse;
import com.msn.riyad.user.dto.UserRegistrationRequest;
import com.msn.riyad.user.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.msn.riyad.user.repository.UserRepository;
import java.util.List;

@Service
public class UserServiceImplements implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImplements.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserLoginResponse performCustomerLogin(UserLoginRequest request) throws Exception {
        UserLoginResponse response = new UserLoginResponse();
        LOGGER.info("======== START CustomerServiceImpl.performCustomerLogin() with request : " + request);

        User user = userRepository.findByEmail(request.getEmail());

        if (user != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            boolean isPwdMatched = passwordEncoder.matches(request.getPassword(), user.getPassword());
            user.setIsActive(Boolean.FALSE);
            userRepository.save(user);
            if (isPwdMatched) {
                response.setResultMsg("Successfully logged-in");
                response.setCustomerId(user.getId());
                response.setEmail(user.getEmail());
                response.setIsActive(user.getIsActive());
                LOGGER.info("======== CustomerServiceImpl.performCustomerLogin() - Login success for user email no:" + user.getEmail());
            } else {
                response.setResultMsg("Wrong/invalid password");
                LOGGER.info("======== CustomerServiceImpl.performCustomerLogin() - Login failed due to invalid password");
            }
        } else {
            response.setResultMsg("Mobile phone no is not registered");
            LOGGER.info("======== CustomerServiceImpl.performCustomerLogin() - Login failed since mobile no " + request.getEmail() + " could not be found");
        }
        return response;
    }

    @Override
    public UserLoginResponse performCustomerLogout(String email) throws Exception {
        UserLoginResponse response = new UserLoginResponse();
        LOGGER.info("======== START CustomerServiceImpl.performCustomerLogout() with email " + email);

        User user = userRepository.findByEmail(email);

        if (user != null) {
            //update login status
            user.setIsActive(Boolean.FALSE);
            userRepository.save(user);

            response.setResultMsg("Successfully logged-out");
            
            LOGGER.info("======== END CustomerServiceImpl.performCustomerLogout() - Logout email " + email + " success");
        } else {
            response.setResultMsg("Logout failed. Email could not be found");
            LOGGER.info("======== END CustomerServiceImpl.performCustomerLogout() - Logout email " + email + " failed");
        }
        return response;
    }
    
    @Override
    public BaseResponse performCustomerRegistration(UserRegistrationRequest request) {
        BaseResponse response = new BaseResponse();

        try {
            LOGGER.info("======== START CustomerServiceImpl.performCustomerRegistration() with request : " + request);

            //validation
            User userVal1 = userRepository.findByEmail(request.getEmail());
            if (userVal1 != null) {
                //response
                response.setResultMsg("Email you entered is already registered");
                return response;
            }

            Pattern pattern = Pattern.compile("^(.+)@(.+)$");
            Matcher m = pattern.matcher(request.getEmail());
            if (!m.matches()) {
                response.setResultMsg("Email you entered is invalid.");
                return response;
            }

            //Save the request to DB
            User user = new User();
            user.setEmail(request.getEmail());
            user.setAge(request.getAge());
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setIsActive(Boolean.FALSE);
//            this.retJob(user);
            userRepository.save(user);

            //response
            response.setResultMsg("Registration success");
            LOGGER.info("======== CustomerServiceImpl.performCustomerRegistration() - Registration with email " + user.getEmail() + " success");
        } catch (Exception e) {
            //response
            response.setResultMsg("Registration failed : " + e.getMessage());
        }

        return response;
    }

    @Override
    public UserDetailResponse performCustomerInquiry() throws Exception {
        UserDetailResponse response = new UserDetailResponse();
        LOGGER.info("======== START CustomerServiceImpl.performCustomerInquiry()");

        List<User> users = userRepository.findAll();

        if (users != null) {
            for (User user : users) {
                response.setEmail(user.getEmail());
                response.setIsActive(user.getIsActive());
                response.setResultMsg("Success");
            }
            LOGGER.info("======== CustomerServiceImpl.performCustomerInquiry() - Customer found :" + response);
        } else {
            response.setResultMsg("Customer not found");
            LOGGER.info("======== CustomerServiceImpl.performCustomerInquiry() - Customer not found");
        }
        return response;
    }
    
    public List<User> retJob(User user) throws Exception {
        return null;
    }

    @Override
    public void job() {
        LOGGER.info("======== START CustomerServiceImpl.job()");
        
    }
}

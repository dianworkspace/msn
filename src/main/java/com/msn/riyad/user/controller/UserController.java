package com.msn.riyad.user.controller;

import com.msn.riyad.user.dto.BaseResponse;
import com.msn.riyad.user.dto.UserDetailResponse;
import com.msn.riyad.user.dto.UserLoginRequest;
import com.msn.riyad.user.dto.UserLoginResponse;
import com.msn.riyad.user.dto.UserRegistrationRequest;
import com.msn.riyad.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Riyad
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doLogin(@RequestBody UserLoginRequest request) {
        LOGGER.info("\n\n======== START UserController.doLogin");
        UserLoginResponse response = new UserLoginResponse();

        try {
            response = userService.performCustomerLogin(request);
            LOGGER.info("======== COMPLETED UserController.doLogin");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/logout/{mobileNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doLogout(@RequestBody String email){
        LOGGER.info("\n\n======== START UserController.doLogout mobile no " + email);
        UserLoginResponse response = new UserLoginResponse();

        try {
            response = userService.performCustomerLogout(email);
            LOGGER.info("======== COMPLETED UserController.doLogout mobile no " + email);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doRegister(@RequestBody UserRegistrationRequest request){
        LOGGER.info("\n\n======== START UserController.doRegistration");
        BaseResponse response = new BaseResponse();

        try {
            response = userService.performCustomerRegistration(request);
            LOGGER.info("======== COMPLETED UserController.doRegistration");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/user/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doInquiry(){
        LOGGER.info("\n\n======== START CustomerController.doInquiry");
        UserDetailResponse response = new UserDetailResponse();

        try {
            response = userService.performCustomerInquiry();
            LOGGER.info("======== COMPLETED CustomerController.doInquiry");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

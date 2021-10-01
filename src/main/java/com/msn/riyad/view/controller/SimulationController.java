package com.msn.riyad.view.controller;

import com.msn.riyad.user.controller.UserController;
import com.msn.riyad.user.dto.BaseResponse;
import com.msn.riyad.user.dto.UserDetailResponse;
import com.msn.riyad.user.dto.UserLoginRequest;
import com.msn.riyad.user.dto.UserLoginResponse;
import com.msn.riyad.user.dto.UserRegistrationRequest;
import com.msn.riyad.user.model.User;
import com.msn.riyad.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Riyad
 *
 */
@Controller
@RequestMapping("/simulation")
public class SimulationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public String doInquiry(Model model) {
        LOGGER.info("\n\n======== START CustomerController.doInquiry");
        UserDetailResponse response = new UserDetailResponse();

        try {
            response = userService.performCustomerInquiry();
            model.addAttribute("users", response);
            LOGGER.info("======== COMPLETED CustomerController.doInquiry");
            return "index";
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return "index";
        }
    }

//    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String doLogin(@RequestBody UserLoginRequest request, Model model) {
//        LOGGER.info("\n\n======== START UserController.doLogin");
//        UserLoginResponse response = new UserLoginResponse();
//
//        try {
//            response = userService.performCustomerLogin(request);
//            LOGGER.info("======== COMPLETED UserController.doLogin");
//            return "";
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage(), e);
//            return "";
//        }
//    }

//    @PostMapping(value = "/logout/{mobileNo}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String doLogout(@RequestBody String email) {
//        LOGGER.info("\n\n======== START UserController.doLogout mobile no " + email);
//        UserLoginResponse response = new UserLoginResponse();
//
//        try {
//            response = userService.performCustomerLogout(email);
//            LOGGER.info("======== COMPLETED UserController.doLogout mobile no " + email);
//            return "regis";
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage(), e);
//            return "regis";
//        }
//    }

    @GetMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public String inquiryRegister(Model model) {
        LOGGER.info("\n\n======== START UserController.showUser");
        try {
            model.addAttribute("UserRegistrationRequest", new UserRegistrationRequest());
            LOGGER.info("======== COMPLETED UserController.showUser");
            return "register";
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return "register";
        }

    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public String doRegister(@ModelAttribute UserRegistrationRequest request, Model model) {
        LOGGER.info("\n\n======== START UserController.doRegistration");
        BaseResponse response = new BaseResponse();

        try {
            response = userService.performCustomerRegistration(request);
            model.addAttribute("UserRegistrationRequest", response);
            LOGGER.info("======== COMPLETED UserController.doRegistration");
            return "redirect:/simulation/login";
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return "redirect:/simulation/login";
        }
    }

//    @GetMapping(value = "/user/", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> doInquiry(){
//        LOGGER.info("\n\n======== START CustomerController.doInquiry");
//        UserDetailResponse response = new UserDetailResponse();
//
//        try {
//            response = userService.performCustomerInquiry();
//            LOGGER.info("======== COMPLETED CustomerController.doInquiry");
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            LOGGER.error(e.getMessage(), e);
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
}

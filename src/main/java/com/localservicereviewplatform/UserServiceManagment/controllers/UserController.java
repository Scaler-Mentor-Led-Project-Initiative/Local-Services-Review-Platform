package com.localservicereviewplatform.UserServiceManagment.controllers;

import com.localservicereviewplatform.UserServiceManagment.services.UserService;


public class UserController {

  private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }
}

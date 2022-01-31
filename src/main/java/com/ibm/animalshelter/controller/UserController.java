package com.ibm.animalshelter.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/user")
@Api(value = "API REST User")
public class UserController {

    Logger logger = Logger.getLogger("com.ibm.animalshelter.controller");

    @GetMapping("/userInfo")
    @Operation(summary = "Exibe as informações do usuário")
    @Secured({"ROLE_USER"})
    public UserDetails userInfo(@AuthenticationPrincipal UserDetails user){
        logger.info("Informações do usuário exibidas");
        return user;
    }
}

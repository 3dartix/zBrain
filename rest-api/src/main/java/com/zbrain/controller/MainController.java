package com.zbrain.controller;

import com.zbrain.entity.Email;
import com.zbrain.exception.DuplicateException;
import com.zbrain.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/email")
@RestController
@CommonsLog
@Api("CRUD operations for email")
public class MainController {

    @Autowired
    private EmailService emailService;

    @PostMapping(path = "/add", produces = "application/json")
    @ApiOperation("add email")
    public ResponseEntity<String> createEmail(@ApiParam("cannot be empty")@Valid @RequestBody Email email, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.info(bindingResult.getAllErrors());
            return new ResponseEntity<>("not empty", HttpStatus.BAD_REQUEST);
        }

        if(emailService.isEmailExist(email.getEmail())){
            log.info(bindingResult.getAllErrors());
            throw new DuplicateException("duplicate");
        } else {
            emailService.save(email);
        }

        return new ResponseEntity<>(HttpStatus.OK);

        //альтернатива
//        try {
//            emailService.save(email);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e){
//            log.info(bindingResult.getAllErrors());
//            throw new DuplicateException("duplicate");
//        }
    }
}

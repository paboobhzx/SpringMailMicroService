package com.ms.springmail.controllers;


import com.fasterxml.jackson.databind.util.BeanUtil;
import com.ms.springmail.dtos.EmailDto;
import com.ms.springmail.models.EmailModel;
import com.ms.springmail.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<EmailModel> emailSender(@RequestBody @Valid EmailDto emailDto){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto,emailModel);;
        emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }
}

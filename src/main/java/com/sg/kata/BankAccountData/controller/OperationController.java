package com.sg.kata.BankAccountData.controller;


import com.sg.kata.BankAccountData.model.Operation;
import com.sg.kata.BankAccountData.model.User;
import com.sg.kata.BankAccountData.service.OperationService.IOperationService;
import com.sg.kata.BankAccountData.service.UserService.IUserService;
import com.sg.kata.BankAccountData.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/v1/api/operations/")
public class OperationController {

    @Autowired
    IUserService userService;

    @Autowired
    IOperationService operationService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveOperation(@RequestBody Operation operation) {

        if (operation == null) {
            return ResponseEntity.badRequest().build();
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User operationCreator = userService.getUserByUsername(currentPrincipalName);
        operation.setUser(operationCreator);
        operation.setOperationDate(new Date());
        Operation savedOperation = operationService.saveOperation(operation);
        return ResponseEntity.ok(savedOperation);
    }

}


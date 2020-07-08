package com.sg.kata.BankAccountData.controller;

import com.sg.kata.BankAccountData.model.Account;
import com.sg.kata.BankAccountData.model.Operation;
import com.sg.kata.BankAccountData.model.User;
import com.sg.kata.BankAccountData.service.AccountService.IAccountService;
import com.sg.kata.BankAccountData.service.OperationService.IOperationService;
import com.sg.kata.BankAccountData.service.UserService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/accounts/")
public class AccountController {

    @Autowired
    IUserService userService;

    @Autowired
    IAccountService accountService;

    @Autowired
    IOperationService operationService;

    @RequestMapping(value = "{id}/operations", method = RequestMethod.GET)
    public ResponseEntity<List<Operation>> getAccountHistory(@PathVariable("id") Integer id) {

        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        Account account = accountService.getAccountById(id);

        if (account == null) {
            return ResponseEntity.notFound().build();
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User connectedUser = userService.getUserByUsername(currentPrincipalName);


        //if the person asking for the account history is not his owner, we block him with unauthorized error
        if (account.getOwner() != connectedUser) {
            return ResponseEntity.status(401).build();
        }

        List<Operation> history = operationService.getAccountHistory(account);
        return ResponseEntity.ok(history);
    }

}


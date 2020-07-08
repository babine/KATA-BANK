package com.sg.kata.BankAccountData.service.AccountService;

import com.sg.kata.BankAccountData.model.Account;
import com.sg.kata.BankAccountData.model.User;

import java.util.List;

public interface IAccountService {

    Account getAccountById(Integer id);
    List<Account> getAccountOfUser(User user);
    Account saveAccount(Account account);
}

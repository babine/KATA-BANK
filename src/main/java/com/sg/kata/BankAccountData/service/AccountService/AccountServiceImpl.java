package com.sg.kata.BankAccountData.service.AccountService;

import com.sg.kata.BankAccountData.dao.AccountRepository;
import com.sg.kata.BankAccountData.model.Account;
import com.sg.kata.BankAccountData.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {


    @Autowired
    AccountRepository accountDao;

    @Override
    public Account getAccountById(Integer id) {
        return accountDao.findByAccountId(id);
    }

    @Override
    public List<Account> getAccountOfUser(User user) {
        return accountDao.findByOwner(user);
    }

    @Override
    public Account saveAccount(Account account) {
        return accountDao.save(account);
    }
}

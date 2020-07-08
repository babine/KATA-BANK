package com.sg.kata.BankAccountData.service.OperationService;

import com.sg.kata.BankAccountData.model.Account;
import com.sg.kata.BankAccountData.model.Operation;
import com.sg.kata.BankAccountData.model.User;

import java.util.List;

public interface IOperationService {
    Operation getOperationById(Integer id);
    List<Operation> getAccountHistory(Account account);
    Operation saveOperation(Operation operation);
}

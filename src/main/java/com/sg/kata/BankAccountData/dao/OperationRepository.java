package com.sg.kata.BankAccountData.dao;

import com.sg.kata.BankAccountData.model.Account;
import com.sg.kata.BankAccountData.model.Operation;
import com.sg.kata.BankAccountData.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OperationRepository extends CrudRepository<Operation, Integer> {

    List<Operation> findByAccount(Account account);

    Operation findByOperationId(Integer operationId);

    List<Operation> findByUser(User user);

}
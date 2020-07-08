package com.sg.kata.BankAccountData.service.OperationService;

import com.sg.kata.BankAccountData.dao.OperationRepository;
import com.sg.kata.BankAccountData.model.Account;
import com.sg.kata.BankAccountData.model.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements IOperationService{

    @Autowired
    OperationRepository operationDao;


    @Override
    public Operation getOperationById(Integer id) {
        return operationDao.findByOperationId(id);
    }

    @Override
    public List<Operation> getAccountHistory(Account account) {
        return operationDao.findByAccount(account);
    }

    @Override
    public Operation saveOperation(Operation operation) {
        return operationDao.save(operation);
    }
}

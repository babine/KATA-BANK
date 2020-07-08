package com.sg.kata.BankAccountData.dao;

import com.sg.kata.BankAccountData.model.Account;
import com.sg.kata.BankAccountData.model.Operation;
import com.sg.kata.BankAccountData.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    @Query("update Account c set c.balance = :balance WHERE c.accountId = :accountId")
    void setAccountBalance(@Param("balance") String balance, @Param("accountId") Integer accountId);

    Account findByAccountId(Integer accountId);

    List<Account> findByOwner(User owner);

}
package com.sg.kata.BankAccountData.dao;

import com.sg.kata.BankAccountData.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(" select u from User u " +
            " where u.username = ?1")
    Optional<User> findUserWithName(String username);

    User findByUserId(Integer userId);

    User findByUsernameAndPassword(String username, String password);

}

package com.se190167.mvc.horseracingtournament.service;

import com.se190167.mvc.horseracingtournament.entity.Account;
import com.se190167.mvc.horseracingtournament.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Account> getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}
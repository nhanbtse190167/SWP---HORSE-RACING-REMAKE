package com.se190167.mvc.horseracingtournament.repository;

import com.se190167.mvc.horseracingtournament.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    // Tìm account theo username
    Optional<Account> findByUsername(String username);
}
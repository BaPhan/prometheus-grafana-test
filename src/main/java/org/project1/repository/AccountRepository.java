package org.project1.repository;

import org.project1.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByUsername(String username);
}

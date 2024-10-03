package org.project1.service;

import org.project1.entity.Account;
import org.project1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    private Map<String, String> map = new HashMap<>();
    private Map<String, Object> map2 = new HashMap<>();

    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(accountRepository.findAll());
    }

    public ResponseEntity<?> findByUsername(String username) {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            map.put("status", "405");
            map.put("error_desc", "no data!");
            return ResponseEntity.badRequest().body(map);
        } else {
            map2.put("status", "200");
            map2.put("data", account);
            return ResponseEntity.ok(map);
        }
    }

    public void dummyData() {
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        for (int i = 1; i <= 100; i++) {
            account.setName("user" + i);
            account.setUsername("username" + i);
            account.setPassword("password" + i);
            accounts.add(account);
        }
        accountRepository.saveAll(accounts);
    }
}

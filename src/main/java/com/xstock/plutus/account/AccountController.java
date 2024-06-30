package com.xstock.plutus.account;

import com.xstock.plutus.utils.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        if (createdAccount == null) {
            throw new ResourceNotFoundException();
        }
        return createdAccount;
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        if (account == null) {
            throw new ResourceNotFoundException();
        }
        return account;
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id, @RequestBody Account account) {
        Account updatedAccount = accountService.updateAccount(id, account);
        if (updatedAccount == null) {
            throw new ResourceNotFoundException();
        }
        return updatedAccount;
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}

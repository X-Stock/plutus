package com.xstock.plutus.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        return optionalAccount.orElse(null);
    }

    public Account updateAccount(Long id, Account updateAccount) {
        Optional<Account> optionalExistingAccount = accountRepository.findById(id);
        if (optionalExistingAccount.isPresent()) {
            Account existingAccount = optionalExistingAccount.get();
            existingAccount.setUsername(updateAccount.getUsername());
            existingAccount.setPassword(updateAccount.getPassword());
            // Cập nhật các trường dữ liệu khác nếu cần
            return accountRepository.save(existingAccount);
        }
        return null;
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}

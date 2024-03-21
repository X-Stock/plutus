package com.xstock.plutus.account;

import com.xstock.plutus.account.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {

}

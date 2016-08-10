package service;


import entity.Account;

import java.util.List;

public interface AccountService extends Service<Account> {

    public List<Account> getByUserId(Long userId);
}

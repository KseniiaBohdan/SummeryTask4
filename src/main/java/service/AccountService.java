package service;


import data.entity.Account;
import data.entity.Status;

import java.util.List;

public interface AccountService extends Service<Account> {

    public List<Account> getByUserId(Long userId);

    Account getByAccountId(Long id);

    boolean deleteById(Long account_id);

    boolean create(Account ac, Long userId);

    void removeAccountByStatus(List<Account> accountList, Status... status);
}

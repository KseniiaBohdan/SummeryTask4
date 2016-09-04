package service.comand.impl;

import data.entity.Account;
import data.entity.Status;
import service.AccountRequestService;
import service.AccountService;
import service.comand.Command;
import service.impl.AccountRequestServiceImpl;
import service.impl.AccountServiceImpl;

import javax.naming.Context;
import java.util.Map;

public class UnblockAccountCommand implements Command {

    private static final String ACCOUNT_ID = "accountId";

    public Object execute(Context context, Map<String, Object> params) {
        Long accountId = Long.valueOf(params.get(ACCOUNT_ID).toString());
        AccountService accountService = new AccountServiceImpl();
        Account account = accountService.getByAccountId(accountId);
        account.setStatus(Status.ACTIVE);
        accountService.update(account);
        AccountRequestService accountRequestService = new AccountRequestServiceImpl();
        accountRequestService.deleteByAccountId(accountId);
        return account;
    }
}

package service;

import data.entity.AccountRequest;

public interface AccountRequestService extends Service<AccountRequest>{

    boolean deleteByAccountId(Long accountId);
}

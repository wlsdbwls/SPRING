package com.example.demo.account.service;

import com.example.demo.account.controller.form.AccountLoginRequestForm;
import com.example.demo.account.controller.form.AccountResponseForm;
import com.example.demo.account.service.request.AccountRegisterRequest;

public interface AccountService {
    Boolean register(AccountRegisterRequest accountRegisterRequest);
    String login(AccountLoginRequestForm accountLoginRequestForm);
    Long findAccountIdByEmail(String email);
    Boolean checkEmailDuplication(String email);
    AccountResponseForm getAccountInfoById(Long accountId);
}

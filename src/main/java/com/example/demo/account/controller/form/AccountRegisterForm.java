package com.example.demo.account.controller.form;

import com.example.demo.account.service.request.AccountRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRegisterForm {

    final private String email;
    final private String password;

    public AccountRegisterRequest toAccountRegisterRequest () {

        return new AccountRegisterRequest(
                email, password);
    }
}

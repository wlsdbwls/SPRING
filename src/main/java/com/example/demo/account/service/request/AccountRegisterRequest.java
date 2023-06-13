package com.example.demo.account.service.request;

import com.example.demo.account.entity.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountRegisterRequest {

    final private String email;
    final private String password;

    public Account toAccount () {
        return new Account(email, password);
    }
}

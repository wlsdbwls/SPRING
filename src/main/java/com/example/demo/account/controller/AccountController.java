package com.example.demo.account.controller;

import com.example.demo.account.controller.form.AccountLoginRequestForm;
import com.example.demo.account.controller.form.AccountRegisterForm;
import com.example.demo.account.service.AccountService;
import com.example.demo.redis.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    final private AccountService accountService;
    final private RedisService redisService;

    @PostMapping("/register")
    public Boolean accountRegister (@RequestBody AccountRegisterForm requestForm) {
        return accountService.register(requestForm.toAccountRegisterRequest());
    }

    @PostMapping("/login")
    public String accountLogin(@RequestBody AccountLoginRequestForm accountLoginRequestForm) {

        String userToken = accountService.login(accountLoginRequestForm);
        Long accountID= accountService.findAccountIdByEmail(accountLoginRequestForm.getEmail());
        redisService.setKeyAndValue(userToken,accountID);

        return userToken;
    }

    @GetMapping("/check-email/{email}")
    public Boolean checkEmail(@PathVariable("email") String email) {

        return accountService.checkEmailDuplication(email);
    }
}

package com.example.demo.account.service;

import com.example.demo.account.controller.form.AccountLoginRequestForm;
import com.example.demo.account.entity.Account;
import com.example.demo.account.repository.AccountRepository;
import com.example.demo.account.repository.UserTokenRepository;
import com.example.demo.account.repository.UserTokenRepositoryImpl;
import com.example.demo.account.service.request.AccountRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    final private AccountRepository accountRepository;
    final private UserTokenRepository userTokenRepository = UserTokenRepositoryImpl.getInstance();

    @Override
    public Boolean register(AccountRegisterRequest request) {
        final Optional<Account> maybeAccount = accountRepository.findByEmail(request.getEmail());

        if (maybeAccount.isPresent()) {
            return false;
        }

        // 계정 생성
        final Account account = accountRepository.save(request.toAccount());

        return true;
    }

    @Override
    public String login(AccountLoginRequestForm requestForm) {
        Optional<Account> maybeAccount = accountRepository.findByEmail(requestForm.getEmail());

        if(maybeAccount.isPresent()) {
            if(requestForm.getPassword().equals(maybeAccount.get().getPassword())) {
                final Account account = maybeAccount.get();
                final String userToken = UUID.randomUUID().toString();
                userTokenRepository.save(userToken, account.getId());
                return userToken;
            }
        }

        return null;
    }

    @Override
    public Long findAccountIdByEmail(String email) {
        Optional<Account> maybeAccount = accountRepository.findByEmail(email);

        if (maybeAccount.isPresent()){
            return maybeAccount.get().getId();
        }

        return null;
    }
}

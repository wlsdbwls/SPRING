package com.example.demo.account.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class AfterLoginRequestForm {

    final private String userToken;
}

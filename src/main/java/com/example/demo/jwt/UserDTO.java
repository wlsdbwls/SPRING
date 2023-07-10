package com.example.demo.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 토큰 생성 후 반환할 DTO 생성
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private String token;
    private String email;
    private String username;
    private String password;
    private String id;
}

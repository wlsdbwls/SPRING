//package com.example.demo.jwt;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//// 로그인 API를 호출하게 되면 토큰을 생성 및 반환
//@Slf4j
//@RestController
//@RequestMapping("auth")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private TokenProvider tokenProvider;
//
//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO) {
//        UserEntity user = userService.getByCredentials(userDTO.getEmail(), userDTO.getPassword());
//
//        // 사용자의 id, pwd 일치할 경우
//        if (user != null) {
//            // 토큰 생성
//            final String token = tokenProvider.create(user);
//            final UserDTO responseUserDTO = UserDTO.builder()
//                    .email(userDTO.getEmail())
//                    .id(userDTO.getId())
//                    .token(token)
//                    .build();
//            return ResponseEntity.ok().body(responseUserDTO);
//        } else {
//            ResponseDTO responseDTO = ResponseDTO.builder()
//                    .error("Login failed")
//                    .build();
//            return ResponseEntity.badRequest().body(responseDTO);
//        }
//    }
//}

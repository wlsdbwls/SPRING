//package com.example.demo.jwt;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.Date;
//
//@Slf4j
//@Service
//public class TokenProvider {
//    final private static String SECRET_KEY = "NMA8jpctFuna59f5";
//
//    public String create(UserEntity userEntity) {
//        // 기한은 지금부터 1일로 설정
//        Date expiryDate = Date.from(
//                Instant.now()
//                        .plus(1, ChronoUnit.DAYS));
//
//        /*
//         *    ---- 토큰 구조 ----
//         *  { // header
//         *  	"alg" : "HS512"
//         *  },
//         *  { // payload
//         *  	"sub" : "40288093784915d201784916a40c0001",
//         *  	"iss" : "demo app",
//         *  	"iat" : 1595733657,
//         *  	"exp" : 1596597657
//         *  }.
//         *  // SECRET_KEY를 이용해 서명한 부분
//         *  Nn4d1MOVLZg79sfFACTIpCPKqWmpZMZQ.....
//         */
//
//        // JWT Token 생성
//        return Jwts.builder()
//                // header에 들어갈 내용 및 서명을 하기 위한 SECRET_KEY
//                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
//                // payload에 들어갈 내용
//                .setSubject(userEntity.getId()) // sub
//                .serIssuer("demo app") // iss
//                .setIssuedAt(new Date()) //iat
//                .setExpiration(expiryDate) //exp
//                .compact();
//    }
//
//    public String validateAndGetUserId(String token) {
//        // parseClaimsJws 메서드가 Base64로 디코딩 및 파싱
//        // 헤더와 페이로드를 setSigningKey로 넘어온 시크릿을 이용해 서명한 후 token의 서명과 비료
//        // 위조되지 않았다면 payload 리턴, 위조라면 예외를 날림
//        // 그중 여기서는 userId가 필요하기 때문에 getBody를 부른다
//        Claims claims = Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody();
//
//        return claims.getSubject(); // subject 즉 사용자 아이디를 리턴한다
//    }
//}

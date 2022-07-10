package com.example.spring_security_jwt_simple.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

  private static final String SECRET_KEY = "lfhfwafhbwafbakjfnwlkfnlbefihbwaejkfhbjjdhvwhjd";

  public String createToken(String subject, long expTime) {
    if (expTime <= 0) { // expTime 시간 체크
      throw new RuntimeException("만료시간이 0보다 커야됩니다.");
    }

    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; // 서명 암호화 알고리즘 선택

    byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY); // 시크릿키를 base64binary로

    Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName()); // 바이트화한 시크릿 키를 기반으로 키생성

    // 생성한 키를 바탕으로 Jwts 생성
    return Jwts.builder()
        .setSubject(subject)
        .signWith(signingKey, signatureAlgorithm)
        .setExpiration(new Date(System.currentTimeMillis() + expTime))
        .compact();
  }


  public String getSubject(String token) {
    // 입력받은 token을 기반으로 파싱해서 subject 찾기
    Claims claims = Jwts.parserBuilder()
        .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
        .build()
        .parseClaimsJws(token)
        .getBody();

    return claims.getSubject();
  }
}

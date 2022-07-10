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
    if (expTime <= 0) {
      throw new RuntimeException("만료시간이 0보다 커야됩니다.");
    }

    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
    System.out.println(secretKeyBytes);
    Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());

    return Jwts.builder()
        .setSubject(subject)
        .signWith(signingKey, signatureAlgorithm)
        .setExpiration(new Date(System.currentTimeMillis() + expTime))
        .compact();
  }


  public String getSubject(String token) {
    Claims claims = Jwts.parserBuilder()
        .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
        .build()
        .parseClaimsJws(token)
        .getBody();

    return claims.getSubject();
  }
}

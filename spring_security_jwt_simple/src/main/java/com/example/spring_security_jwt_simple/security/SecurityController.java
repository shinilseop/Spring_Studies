package com.example.spring_security_jwt_simple.security;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {

  @Autowired
  private SecurityService securityService;

  @GetMapping("/create/token")
  public Map<String, Object> createToken(@RequestParam(value = "subject") String subject) {
    // 받은 subject를 기반으로 2분간 유지되는 token을 하나 만들어서 반환
    String token = securityService.createToken(subject, (2 * 1000 * 60));
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("result", token);
    return map;
  }

  @GetMapping("/get/subject")
  public Map<String, Object> getSubject(@RequestParam(value = "token") String token) {
    // 받은 token을 기반으로 그에 맞는 subject를 찾아서 반환
    String subject = securityService.getSubject(token);
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("result", subject);
    return map;
  }
}

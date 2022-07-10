package com.example.springboot_security_jwt.exception;

public class DuplicateMemberException extends RuntimeException {

  public DuplicateMemberException(String message) {
    super(message);
  }
}

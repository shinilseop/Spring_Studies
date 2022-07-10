package com.example.springboot_security_jwt.dto;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

  @NotNull
  @Size(min = 3, max = 50)
  private String username;


  @NotNull
  @Size(min = 3, max = 100)
  private String password;
}

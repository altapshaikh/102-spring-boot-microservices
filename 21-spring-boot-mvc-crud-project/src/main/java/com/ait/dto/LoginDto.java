package com.ait.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {
   @Email(message = "Please enter a valid email address.")
   @NotBlank(message = "Please enter your email value.")
   private String email;

   @NotBlank(message = "Please enter your password value.")
  // @Min(value = 8)
  // @Max(value=15)
   private String password;
}

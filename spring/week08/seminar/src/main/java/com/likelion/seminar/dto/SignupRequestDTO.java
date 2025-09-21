package com.likelion.seminar.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SignupRequestDTO {
    @NotBlank
    private String username;

    @Email
    private String email;

    @Size(min = 8, max = 20)
    private String password;

}

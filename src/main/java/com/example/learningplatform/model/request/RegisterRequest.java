package com.example.learningplatform.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterRequest {

    @NotNull
    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotNull
    @NotBlank(message = "Firstname is mandatory")
    private String firstname;

    @NotNull
    @NotBlank(message = "Lastname is mandatory")
    private String lastname;

    @NotNull
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotNull
    @NotBlank
    private String password;
}

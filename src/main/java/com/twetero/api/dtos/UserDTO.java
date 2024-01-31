package com.twetero.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank(message = "Fild username is mandatory")
    @Size(max = 100, message = "The maximum length allowed is 100 characters")
    private String username;

    @NotBlank(message = "Fild avatar is mandatory")
    private String avatar;
}

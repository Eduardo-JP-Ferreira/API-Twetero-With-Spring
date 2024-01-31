package com.twetero.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TweetDTO {

    @NotNull
    private Long userId;

    @NotBlank(message = "Fild text is mandatory")
    @Size(max = 280, message = "The maximum length allowed is 280 characters")
    private String text;
}

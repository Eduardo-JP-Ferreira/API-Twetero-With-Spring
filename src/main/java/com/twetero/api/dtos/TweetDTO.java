package com.twetero.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TweetDTO {

    @NotNull
    private Long userId;

    @NotBlank
    private String text;
}

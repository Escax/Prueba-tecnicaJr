package com.escax.crud.dto;

import jakarta.validation.constraints.NotBlank;

public record OrdersDTO (
        Long id,

        @NotBlank(message = "Description is required")
        String description,

        Long userId
){}

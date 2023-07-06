package com.rufino.product.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

//Validação dos dados
public record ProductRecordDto(@NotBlank String name, @PositiveOrZero BigDecimal value) {
}

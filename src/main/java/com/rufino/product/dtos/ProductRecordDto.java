package com.rufino.product.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

//PositiveOrZero aceita o valor "null", por isso adicionei a anotação "NotNull" tb

public record ProductRecordDto(@NotBlank String name, @NotNull @PositiveOrZero BigDecimal value) {
}

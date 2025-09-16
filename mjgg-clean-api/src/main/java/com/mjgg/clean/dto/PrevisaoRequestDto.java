package com.mjgg.clean.dto;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrevisaoRequestDto {
    private BigDecimal precoGasolina;
    private BigDecimal kmCidade;
    private BigDecimal kmRodovia;
}
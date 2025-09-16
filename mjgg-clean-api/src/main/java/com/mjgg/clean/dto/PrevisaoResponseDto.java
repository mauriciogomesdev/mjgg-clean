package com.mjgg.clean.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PrevisaoResponseDto (
    String nome,
    String marca,
    String modelo,
    LocalDate dataFabricacao,
    BigDecimal litrosGastos,
    BigDecimal valorGasto,
    String mensagem
){
    public PrevisaoResponseDto(String nome, String marca, String modelo,
                               LocalDate dataFabricacao, BigDecimal litrosGastos, BigDecimal valorGasto, String mensagem) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.dataFabricacao = dataFabricacao;
        this.litrosGastos = litrosGastos;
        this.valorGasto = valorGasto;
        this.mensagem = mensagem;
    }

}
package com.mjgg.clean.service;

import com.mjgg.clean.dto.PrevisaoRequestDto;
import com.mjgg.clean.dto.PrevisaoResponseDto;
import com.mjgg.clean.entity.Veiculo;
import com.mjgg.clean.repository.VeiculoRepository;
import com.mjgg.clean.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo salvar(Veiculo v) {
        return veiculoRepository.save(v);
    }

    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    public List<PrevisaoResponseDto> calcularPrevisao(PrevisaoRequestDto dto) {
        return veiculoRepository.findAll().stream().map(veiculo -> {
            BigDecimal litrosCidade = dto.getKmCidade().subtract(veiculo.getConsumoCidade());
            BigDecimal litrosRodovia = dto.getKmRodovia().subtract(veiculo.getConsumoRodovia());
            BigDecimal totalLitros = litrosCidade.add(litrosRodovia);
            BigDecimal valorGasto = totalLitros.multiply(dto.getPrecoGasolina());
            return new PrevisaoResponseDto(
                    veiculo.getNome(),
                    veiculo.getMarca(),
                    veiculo.getModelo(),
                    veiculo.getDataFabricacao(),
                    totalLitros,
                    valorGasto,
                    null
            );
        }).sorted(Comparator.comparing(PrevisaoResponseDto::valorGasto, BigDecimal::compareTo))
          .toList();
    }
}
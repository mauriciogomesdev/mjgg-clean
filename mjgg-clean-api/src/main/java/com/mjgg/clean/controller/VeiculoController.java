package com.mjgg.clean.controller;

import com.mjgg.clean.dto.PrevisaoRequestDto;
import com.mjgg.clean.dto.PrevisaoResponseDto;
import com.mjgg.clean.entity.Veiculo;
import com.mjgg.clean.service.VeiculoService;
import com.mjgg.clean.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping
    public List<Veiculo> listar() {
        return service.listar();
    }

    @PostMapping("/previsao")
    public List<PrevisaoResponseDto> previsao(@RequestBody PrevisaoRequestDto request) {
        List<PrevisaoResponseDto> retorno = new ArrayList<>();
        try {
            ValidatorUtil.validarCamposNulos(request);
            retorno = service.calcularPrevisao(request);
        } catch (Exception e) {
            return List.of(new PrevisaoResponseDto(null, null, null, null, null, null, e.getMessage()));
        }
        return retorno;
    }
}
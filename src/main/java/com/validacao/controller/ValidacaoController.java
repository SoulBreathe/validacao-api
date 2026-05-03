package com.validacao.controller;

import com.validacao.dto.ValidacaoRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ValidacaoController {

    private static final List<String> CHAVES_VALIDAS = List.of(
            "T4KW9",
            "B7FQ2",
            "H3ND6",
            "V5RJ1"
    );

    @PostMapping("/verificar")
    public ResponseEntity<String> verificar(@Valid @RequestBody ValidacaoRequest request) {

        boolean existe = CHAVES_VALIDAS.contains(request.getChave());

        String resposta = existe ? "SIM, EXISTE !" : "NÃO EXISTE !";

        return ResponseEntity.ok(resposta);
    }
}

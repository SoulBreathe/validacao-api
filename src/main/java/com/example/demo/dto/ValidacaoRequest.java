package com.example.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ValidacaoRequest {

    /**
     * Exige exatamente 5 caracteres contendo, obrigatoriamente,
     * pelo menos uma letra ([a-zA-Z]) e pelo menos um dígito ([0-9]).
     * Lookaheads garantem a presença de ambos os tipos de caractere.
     */
    @NotNull(message = "O campo 'chave' é obrigatório.")
    @Pattern(
        regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{5}$",
        message = "O campo 'chave' deve ter exatamente 5 caracteres alfanuméricos, contendo letras e números obrigatoriamente."
    )
    private String chave;

    @NotNull(message = "O campo 'valor' é obrigatório.")
    @Min(value = 1, message = "O campo 'valor' deve ser no mínimo 1.")
    @Max(value = 10, message = "O campo 'valor' deve ser no máximo 10.")
    private Integer valor;

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}

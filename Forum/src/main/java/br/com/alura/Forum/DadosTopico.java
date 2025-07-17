package br.com.alura.Forum;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DadosTopico(
        @NotNull
        String id,
    @NotBlank
    String titulo,
    @NotBlank
    String mensagem,
    @NotBlank
    Data dataCriacao,
    @NotBlank
    Status status,
    @NotBlank
    String autor,
    @NotBlank @Valid
    DadosCurso curso,
    @NotBlank @Valid
    DadosResposta resposta
    )
{
}



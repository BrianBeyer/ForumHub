package br.com.alura.Forum;

import jakarta.validation.constraints.NotBlank;

public record DadosResposta(
    @NotBlank
    String mensagem,
    @NotBlank
    String autor,
    @NotBlank
    String solucao
) {
    public DadosResposta(DadosResposta resposta) {
        this(
                resposta.mensagem(),
                resposta.autor(),
                resposta.solucao()
        );
    }


}

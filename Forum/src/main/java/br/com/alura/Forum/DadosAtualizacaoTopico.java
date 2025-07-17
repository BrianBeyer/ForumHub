package br.com.alura.Forum;

public record DadosAtualizacaoTopico(
        String titulo,
        String mensagem,
        Data dataCriacao,
        Status status,
        String autor,
        DadosCurso curso,
        DadosResposta resposta
) {
}

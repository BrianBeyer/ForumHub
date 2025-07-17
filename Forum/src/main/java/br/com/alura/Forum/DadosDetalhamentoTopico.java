package br.com.alura.Forum;


public record DadosDetalhamentoTopico(
        Long id,
        String titulo,
        String mensagem,
        Data dataCriacao,
        Status status,
        String autor,
        DadosCurso curso
) {
    public DadosDetalhamentoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor() != null ? topico.getAutor().getNome() : null,
                topico.getCurso() != null ? new DadosCurso(topico.getCurso()) : null
        );
    }
}

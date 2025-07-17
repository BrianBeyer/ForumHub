package br.com.alura.Forum;

public record DadosListagemTopicos(
        Long id,
        String titulo,
        String mensagem,
        Data dataCriacao
) {
    public DadosListagemTopicos(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao()
        );
    }
}


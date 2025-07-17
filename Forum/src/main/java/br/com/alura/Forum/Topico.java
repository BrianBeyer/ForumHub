package br.com.alura.Forum;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    
    @Embedded
    private Data dataCriacao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @Embedded
    @Valid
    @AttributeOverrides({
            @AttributeOverride(name = "mensagem", column = @Column(name = "resposta_mensagem")),

    })
    private DadosResposta resposta;

    public Topico(DadosTopico dadosTopico) {
        this.titulo = dadosTopico.titulo();
        this.mensagem = dadosTopico.mensagem();
        this.dataCriacao = new Data();
        this.status = dadosTopico.status();
        if (dadosTopico.curso() != null) {
            this.curso = new Curso(dadosTopico.curso());
        }
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoTopico dadosAtualizacaoTopico) {
        if (dadosAtualizacaoTopico.titulo() != null) {
            this.titulo = dadosAtualizacaoTopico.titulo();
        }
        if (dadosAtualizacaoTopico.mensagem() != null) {
            this.mensagem = dadosAtualizacaoTopico.mensagem();
        }
        if (dadosAtualizacaoTopico.status() != null) {
            this.status = dadosAtualizacaoTopico.status();
        }
        if (dadosAtualizacaoTopico.curso() != null) {
            this.curso = new Curso(dadosAtualizacaoTopico.curso());
        }
        if (dadosAtualizacaoTopico.resposta() != null) {
            this.resposta = new DadosResposta(dadosAtualizacaoTopico.resposta());
        }
    }
}

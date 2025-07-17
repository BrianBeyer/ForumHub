package br.com.alura.Forum;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "resposta")
@Entity(name = "Resposta")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    @Embedded
    private Data dataCriacao;
    private String autor;
    private String solucao;

    public Resposta(String mensagem, String autor, String solucao) {
        this.mensagem = mensagem;
        this.autor = autor;
        this.solucao = solucao;
        this.dataCriacao = new Data();
    }
}

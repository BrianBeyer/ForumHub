package br.com.alura.Forum;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "perfil")
@Getter
//@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    public Perfil(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Perfil(DadosPerfil dadosPerfil) {
        this.nome = dadosPerfil.nome();
    }
}

package br.com.alura.Forum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCurso(
        @NotNull
        String id,
        @NotBlank
        String nome,
        @NotBlank
        String categoria
) {
        public DadosCurso(Curso curso) {
                this(
                        curso.getId().toString(),
                        curso.getNome(),
                        curso.getCategoria()
                );
        }
}

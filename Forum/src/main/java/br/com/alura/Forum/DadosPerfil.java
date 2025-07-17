package br.com.alura.Forum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosPerfil( @NotNull
                           String id,
                           @NotBlank String nome) {
}

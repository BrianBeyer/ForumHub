package br.com.alura.Forum.controller;

import br.com.alura.Forum.DadosTopico;
import br.com.alura.Forum.DadosUsuario;
import br.com.alura.Forum.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")

public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void cadastrarUsuario(@RequestBody DadosUsuario dadosUsuario){
        //usuarioRepository.save(dadosUsuario);

    }
}
